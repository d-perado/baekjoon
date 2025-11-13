import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 유형별 점수 저장용 Map
        Map<Character, Integer> map = new HashMap<>();
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char c : types) {
            map.put(c, 0);
        }

        // 점수표 정의
        int[] scoreTable = {3, 2, 1, 0, 1, 2, 3};

        // 설문지 
        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int choice = choices[i];

            if (choice < 4) { // 비동의 → 앞문자 득점
                map.put(first, map.get(first) + scoreTable[choice - 1]);
            } else if (choice > 4) { // 동의 → 뒷문자 득점
                map.put(second, map.get(second) + scoreTable[choice - 1]);
            }
            // choice == 4면 점수 없음
        }

        // 4. 결과 조합
        StringBuilder result = new StringBuilder();

        // 각 지표 쌍 비교
        result.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        result.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        result.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        result.append(map.get('A') >= map.get('N') ? 'A' : 'N');

        return result.toString();
    }
}
