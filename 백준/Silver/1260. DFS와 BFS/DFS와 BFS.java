import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[][] map;
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int i) {
        dfsVisited[i] = true;
        sb.append(i).append(" ");
        for (int j = 1; j <= N; j++) {
            if (!dfsVisited[j] && map[i][j]) {
                dfs(j);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        bfsVisited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for (int j = 1; j <= N; j++) {
                if (!bfsVisited[j] && map[now][j]) {
                    bfsVisited[j] = true;
                    q.offer(j);
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][N + 1];
        dfsVisited = new boolean[N + 1];
        bfsVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = true;
            map[b][a] = true;
        }

        // DFS
        dfs(V);
        sb.append("\n");

        // BFS
        bfs(V);

        System.out.println(sb.toString().trim());
    }
}