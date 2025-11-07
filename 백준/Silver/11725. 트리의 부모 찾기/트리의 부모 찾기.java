import java.io.*;
import java.util.*;

public class Main {
    // 트리 구조를 저장할 인접 리스트 (각 노드의 연결 정보)
    static ArrayList<Integer>[] tree;

    // 각 노드의 부모 노드를 저장할 배열
    static int[] parent;

    // 방문 여부를 저장할 배열 (무한 루프 방지용)
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 노드의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화 (1번부터 N번까지 사용)
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 부모 정보와 방문 배열 초기화
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        // N-1개의 간선 입력 받기 (트리는 항상 N-1개의 간선을 가짐)
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 연결 (트리이므로 무방향 그래프)
            tree[a].add(b);
            tree[b].add(a);
        }

        // 루트(1)부터 DFS 시작
        dfs(1);

        // 결과를 빠르게 출력하기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 2번 노드부터 N번 노드까지 부모 출력
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }

        // 한 번에 출력
        System.out.print(sb);
    }

    static void dfs(int node) {
        // 현재 노드 방문 처리
        visited[node] = true;

        // 현재 노드와 연결된 다른 노드들 탐색
        for (int next : tree[node]) {
            // 아직 방문하지 않은 노드라면
            if (!visited[next]) {
                // 현재 노드가 그 노드의 부모임을 기록
                parent[next] = node;

                // 다음 노드로 재귀적으로 탐색
                dfs(next);
            }
        }
    }
}
