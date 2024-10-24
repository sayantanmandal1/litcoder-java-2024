import java.util.*;

class CustomQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CustomQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value) {
        stack1.push(value);
    }

    public void dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            stack2.pop();
        }
    }

    public int front() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        throw new NoSuchElementException("Queue is empty");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomQueue queue = new CustomQueue();
        String[] commands = scanner.nextLine().trim().split(",");

        for (String command : commands) {
            String[] parts = command.trim().split(" ");
            int cmdType = Integer.parseInt(parts[0]);

            switch (cmdType) {
                case 1:
                    queue.enqueue(Integer.parseInt(parts[1]));
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    try {
                        System.out.println(queue.front());
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
