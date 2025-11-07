import java.io.*;
import java.util.*;

public class Main {
    static int N;                 // 노드의 개수를 저장
    static List<Integer>[] tree;  // 각 노드의 자식 노드 정보를 저장할 리스트 배열
    static boolean[] deleted;     // 삭제된 노드를 표시할 불리언 배열
    static int root;              // 루트 노드의 인덱스를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력의 첫 번째 줄에서 노드의 개수를 입력받는다.
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        deleted = new boolean[N];

        // 각 노드별 자식 리스트를 초기화한다.
        for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();

        // 두 번째 줄에서 각 노드의 부모 정보를 입력받는다.
        // 부모가 -1인 경우 해당 노드는 루트이므로 root 변수에 저장한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) root = i;          // 루트 노드 지정
            else tree[parent].add(i);            // 부모의 자식 리스트에 추가
        }

        // 삭제할 노드의 번호를 입력받는다.
        int cut = Integer.parseInt(br.readLine());

        // 삭제할 노드를 기준으로 하위 모든 노드를 삭제 처리한다.
        deleteNode(cut);

        // 만약 루트가 삭제된 경우 전체 트리가 사라지므로 0을 출력하고 종료한다.
        if (deleted[root]) {
            System.out.println(0);
            return;
        }

        // 루트를 기준으로 리프 노드의 개수를 세어 출력한다.
        System.out.println(countLeaf(root));
    }

    // 특정 노드를 삭제 처리하는 메서드 (자식 노드까지 재귀적으로 삭제)
    static void deleteNode(int node) {
        deleted[node] = true;             // 현재 노드를 삭제 표시한다.
        for (int child : tree[node]) {    // 해당 노드의 모든 자식에 대해
            deleteNode(child);            // 재귀적으로 삭제를 진행한다.
        }
        tree[node].clear();               // 연결 리스트를 비워 연결을 끊는다.
    }

    // 리프 노드(자식이 없는 노드)의 개수를 세는 재귀 메서드
    static int countLeaf(int node) {
        if (deleted[node]) return 0;      // 삭제된 노드는 계산 대상에서 제외한다.

        int childCount = 0;               // 살아 있는 자식의 수를 세기 위한 변수
        int leafCount = 0;                // 리프 노드 개수를 누적할 변수

        // 현재 노드의 자식들을 순회한다.
        for (int child : tree[node]) {
            if (!deleted[child]) {        // 삭제되지 않은 자식이라면
                childCount++;             // 살아 있는 자식 수를 증가시키고
                leafCount += countLeaf(child); // 자식 노드를 기준으로 재귀 호출
            }
        }

        // 자식이 하나도 없으면 리프 노드이므로 1을 반환한다.
        if (childCount == 0) return 1;
        return leafCount;                 // 자식이 있다면 자식 쪽 리프 개수를 반환한다.
    }
}
