import java.util.*;

class CustomStack {
    private StringBuilder text;
    private Stack<String> history;

    public CustomStack() {
        text = new StringBuilder();
        history = new Stack<>();
    }

    public void insert(String value) {
        history.push(text.toString());
        text.append(value);
    }

    public void delete(int value) {
        history.push(text.toString());
        if (value > text.length()) {
            value = text.length();
        }
        text.delete(text.length() - value, text.length());
    }

    public char get(int index) {
        if (index >= 1 && index <= text.length()) {
            return text.charAt(index - 1);
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public void undo() {
        if (!history.isEmpty()) {
            text = new StringBuilder(history.pop());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomStack editor = new CustomStack();
        String[] commands = scanner.nextLine().trim().split(",");

        for (String command : commands) {
            String[] parts = command.trim().split(" ");
            int cmdType = Integer.parseInt(parts[0]);

            switch (cmdType) {
                case 1:
                    editor.insert(parts[1]);
                    break;
                case 2:
                    editor.delete(Integer.parseInt(parts[1]));
                    break;
                case 3:
                    try {
                        char result = editor.get(Integer.parseInt(parts[1]));
                        System.out.println(result);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index out of bounds");
                    }
                    break;
                case 4:
                    editor.undo();
                    break;
            }
        }
    }
}
