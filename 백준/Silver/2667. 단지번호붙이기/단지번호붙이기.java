import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N;

    public static int check(int x, int y, int cnt) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 0) continue;

            cnt = check(nx, ny, cnt + 1);
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0'; // char → int 변환
            }
        }

        int groupCount = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visited[i][j]) continue;
                if (map[i][j] == 0) continue;

                int cnt = check(i, j, 1);
                list.add(cnt);
                groupCount++;
            }
        }

        Collections.sort(list);

        System.out.println(groupCount);
        for (int c : list) System.out.println(c);
    }
}
