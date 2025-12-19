import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char left = st.nextToken().charAt(0);
        char right = st.nextToken().charAt(0);

        String word = br.readLine();

        char[][] keyboard = {
                {'q','w','e','r','t','y','u','i','o','p'},
                {'a','s','d','f','g','h','j','k','l','.'},
                {'z','x','c','v','b','n','m','.','.','.'}
        };

        Set<Character> rightKeys = new HashSet<>(Arrays.asList(
                'y','u','i','o','p',
                'h','j','k','l',
                'b','n','m'
        ));

        Map<Character, int[]> pos = new HashMap<>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 10; c++) {
                if (keyboard[r][c] != '.') {
                    pos.put(keyboard[r][c], new int[]{r, c});
                }
            }
        }

        int[] leftPos = pos.get(left);
        int[] rightPos = pos.get(right);

        int answer = 0;

        for (char ch : word.toCharArray()) {
            answer++;

            int[] target = pos.get(ch);

            if (rightKeys.contains(ch)) {
                answer += Math.abs(rightPos[0] - target[0])
                        + Math.abs(rightPos[1] - target[1]);
                rightPos = target;
            } else {
                answer += Math.abs(leftPos[0] - target[0])
                        + Math.abs(leftPos[1] - target[1]);
                leftPos = target;
            }
        }

        System.out.println(answer);
    }
}