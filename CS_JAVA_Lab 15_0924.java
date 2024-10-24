import java.util.Scanner;

public class Main {
    private static final int MOD = 1000000007;
    private int M, N;
    private long[] ways;

    public Main(int m, int n) {
        M = m;
        N = n;
        ways = new long[N + 1];
        calculateWays();
    }

    private void calculateWays() {
        ways[0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i - j >= 0) {
                    ways[i] = (ways[i] + ways[i - j]) % MOD;
                }
            }
        }
    }

    public long evaluate() {
        long result = 1;
        for (int i = 0; i < M; i++) {
            result = (result * ways[N]) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int m = inp.nextInt();
        int n = inp.nextInt();
        Main T = new Main(m, n);
        System.out.println(T.evaluate());
        inp.close();
    }
}
