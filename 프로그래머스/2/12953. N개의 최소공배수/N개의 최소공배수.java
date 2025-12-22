import java.util.*;

class Solution {
    public int solution(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int x = num;

            for (int p = 2; p * p <= x; p++) {
                int cnt = 0;
                while (x % p == 0) {
                    x /= p;
                    cnt++;
                }
                if (cnt > 0) {
                    map.put(p, Math.max(map.getOrDefault(p, 0), cnt));
                }
            }

            if (x > 1) {
                map.put(x, Math.max(map.getOrDefault(x, 0), 1));
            }
        }

        int answer = 1;
        for (int key : map.keySet()) {
            answer *= Math.pow(key, map.get(key));
        }

        return answer;
    }
}