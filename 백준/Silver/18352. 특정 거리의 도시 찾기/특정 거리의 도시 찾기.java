import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static ArrayList<Integer>[] graph;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }

        // BFS
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(X);
        distance[X] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (distance[cur] == K) continue; // 더 깊이 갈 필요 없음

            for (int next : graph[cur]) {
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                bw.write(i + "\n");
                found = true;
            }
        }

        if (!found) {
            bw.write("-1");
        }

        bw.flush();
    }
}
