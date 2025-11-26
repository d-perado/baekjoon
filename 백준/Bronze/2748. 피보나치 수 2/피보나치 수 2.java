import java.util.*;

class Main {

    static long[] dp = new long[1000000];

    static long fib(int n) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fib(n));
    }
}