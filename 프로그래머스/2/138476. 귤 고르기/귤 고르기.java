import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        Integer[] counts = new Integer[countMap.size()];
        int idx = 0;
        for (int count : countMap.values()) {
            counts[idx++] = count;
        }

        Arrays.sort(counts, (a, b) -> b - a);

        for (int count : counts) {
            k -= count;
            answer++;
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}
