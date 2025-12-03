import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        // 내림차순 정렬
        Arrays.sort(crane, Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        // 가장 무거운 상자 못 옮기면 끝
        if (crane[0] < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;

        // 박스 다 옮기면 끝
        while (!box.isEmpty()) {
            int boxNo = 0;  // 박스 넘버 0부터 돌면서 크레인이랑 무게비교
            for (int i = 0; i < N; i++) { //크레인 갯수만큼 돈다.
                while (boxNo < box.size()) {
                    if (crane[i] >= box.get(boxNo)) {
                        box.remove(boxNo); // 옮기면 삭제
                        break;
                    } else {
                        boxNo++;
                    }
                }
            }
            //크레인 갯수만큼 돌았으면 시간 1초 추가
            time++;
        }

        System.out.println(time);
    }
}
