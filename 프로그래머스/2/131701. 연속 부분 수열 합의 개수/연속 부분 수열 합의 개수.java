import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] arr = new int[n * 2];

        // 원형 배열 처리
        for (int i = 0; i < n; i++) {
            arr[i] = elements[i];
            arr[i + n] = elements[i];
        }

        // 중복 값 제거
        Set<Integer> sums = new HashSet<>();

        // 모든 연속 부분 수열 합 계산
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int len = 1; len <= n; len++) {
                sum += arr[start + len - 1];
                sums.add(sum);
            }
        }

        return sums.size();
    }
}
