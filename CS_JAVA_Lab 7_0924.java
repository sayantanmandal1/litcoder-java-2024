import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int divisor = scanner.nextInt();
        scanner.nextLine();
        String[] inputArray = scanner.nextLine().trim().split(" ");
        int[] ar = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            ar[i] = Integer.parseInt(inputArray[i]);
        }

        int result = countDivisibleSumPairs(ar, divisor);
        System.out.println(result);
    }

    private static int countDivisibleSumPairs(int[] ar, int divisor) {
        int count = 0;
        int n = ar.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar[i] + ar[j]) % divisor == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
