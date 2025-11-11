import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Boolean> skipMap = new HashMap<>();

        for (int i = 0; i < skip.length(); i++) {
            skipMap.put(skip.charAt(i), true);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;

            while (count < index) {
                c++;
                if (c > 'z') c = 'a'; 
                if (!skipMap.containsKey(c)) count++; 
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
