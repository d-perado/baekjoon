import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(jump(0, 0));
    }

    static long jump(int x, int y) {
        if (x == N - 1 && y == N - 1) return 1;
        if (map[x][y] == 0) return 0;

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        int step = map[x][y];

        if (x + step < N) dp[x][y] += jump(x + step, y);
        if (y + step < N) dp[x][y] += jump(x, y + step);

        return dp[x][y];
    }
}