import java.util.*;
import java.io.*;

class Main {

    static int R;
    static int C;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // R: 행, C: 열, N: 시간
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        char[][] startMap = new char[R][C];

        // 초기 맵 입력
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                startMap[i][j] = str.charAt(j);
            }
        }

        // 1초 → 초기 상태 그대로 출력
        if (N == 1) {
            print(startMap);
            return;
        }

        // 짝수 초 → 모든 칸 폭탄
        if (N % 2 == 0) {
            print(fillBomb(new char[R][C]));
            return;
        }

        // 3초 → 초기 맵의 폭탄이 터진 결과
        char[][] firstBomb = Bomb(startMap);

        // 5초 → 3초 결과에서 다시 폭탄 설치 후 터뜨린 결과
        char[][] secondBomb = Bomb(firstBomb);

        if (N % 4 == 3)
            print(firstBomb);
        else
            print(secondBomb);
    }

    // 배열 전체를 폭탄 'O' 로 채우는 함수
    static public char[][] fillBomb(char[][] arr) {
        for (int i = 0; i < R; i++) {
            Arrays.fill(arr[i], 'O');
        }
        return arr;
    }

    // 폭탄을 터뜨리는 함수
    static public char[][] Bomb(char[][] arr) {

        // 4방향(상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 우선 전체 폭탄으로 채움 (폭발 후 ‘남는’ 것만 유지됨)
        char[][] newMap = fillBomb(new char[R][C]);

        // arr에 있던 폭탄이 터지면서 인접 4칸과 자기 자신을 빈칸으로 만든다
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {

                if (arr[x][y] == 'O') { // 기존 폭탄

                    newMap[x][y] = '.'; // 자기 자리 터짐

                    // 주변 4칸 터짐
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                            newMap[nx][ny] = '.';
                        }
                    }
                }
            }
        }

        return newMap;
    }

    // 2차원 배열 출력 함수
    static void print(char[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}