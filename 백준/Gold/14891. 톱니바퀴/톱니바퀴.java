import java.util.*;
import java.io.*;

class Main {
    static List<Integer>[] cogwheel = new ArrayList[4];

    static void rotate(int idx, int dir) {
        if (dir == 1) { // 시계
            int last = cogwheel[idx].remove(7);
            cogwheel[idx].add(0, last);
        } else { // 반시계
            int first = cogwheel[idx].remove(0);
            cogwheel[idx].add(first);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            cogwheel[i] = new ArrayList<>();
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                cogwheel[i].add(s.charAt(j) - '0');
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] dirs = new int[4];
            dirs[idx] = dir;

            // 왼쪽 전파
            for (int l = idx; l > 0; l--) {
                if (cogwheel[l].get(6) != cogwheel[l - 1].get(2)) {
                    dirs[l - 1] = -dirs[l];
                } else break;
            }

            // 오른쪽 전파
            for (int r = idx; r < 3; r++) {
                if (cogwheel[r].get(2) != cogwheel[r + 1].get(6)) {
                    dirs[r + 1] = -dirs[r];
                } else break;
            }

            // 회전 실행
            for (int j = 0; j < 4; j++) {
                if (dirs[j] != 0) {
                    rotate(j, dirs[j]);
                }
            }
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (cogwheel[i].get(0) == 1) {
                score += (1 << i);
            }
        }

        System.out.println(score);
    }
}
