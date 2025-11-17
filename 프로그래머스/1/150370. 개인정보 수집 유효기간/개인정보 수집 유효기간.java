import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        Map<String, Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < terms.length; i++) {
            String[] k = terms[i].split(" ");
            map.put(k[0], Integer.parseInt(k[1]));
        }

        int[][] dates = new int[privacies.length][3];

        for (int i = 0; i < privacies.length; i++) {
            String[] k = privacies[i].split(" ");
            String[] datepart = k[0].split("\\.");

            dates[i][0] = Integer.parseInt(datepart[0]);
            dates[i][1] = Integer.parseInt(datepart[1]);
            dates[i][2] = Integer.parseInt(datepart[2]);

            // 유효기간 더하기
            dates[i][1] += map.get(k[1]);

            while (dates[i][1] > 12) {
                dates[i][1] -= 12;
                dates[i][0] += 1;
            }

            // 하루 빼기
            dates[i][2] -= 1;
            if (dates[i][2] == 0) {
                dates[i][2] = 28;
                dates[i][1] -= 1;
                if (dates[i][1] == 0) {
                    dates[i][1] = 12;
                    dates[i][0] -= 1;
                }
            }
        }

        // today 파싱
        String[] to = today.split("\\.");
        int ty = Integer.parseInt(to[0]);
        int tm = Integer.parseInt(to[1]);
        int td = Integer.parseInt(to[2]);

        // 비교
        for (int i = 0; i < privacies.length; i++) {
            int dy = dates[i][0];
            int dm = dates[i][1];
            int dd = dates[i][2];

            boolean valid = true;

            if (ty > dy) valid = false;
            else if (ty == dy && tm > dm) valid = false;
            else if (ty == dy && tm == dm && td > dd) valid = false;

            // 유효기간이 지났으면 추가
            if (!valid) arr.add(i + 1);
        }

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}
