import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();

        for (String key : keymap) {
            for (int j = 0; j < key.length(); j++) {
                char ch = key.charAt(j);
                int presses = j + 1;

                if (!map.containsKey(ch)) {
                    map.put(ch, presses);
                } else {
                    if (presses < map.get(ch)) {
                        map.put(ch, presses);
                    }
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;
            boolean possible = true;

            for (char ch : target.toCharArray()) {
                if (!map.containsKey(ch)) {
                    possible = false;
                    break;
                }
                sum += map.get(ch);
            }

            answer[i] = possible ? sum : -1;
        }

        return answer;
    }
}
