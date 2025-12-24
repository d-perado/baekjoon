import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        int[] arr = new int[10000001];


        for (int size : tangerine) {
            arr[size]++;
        }


        Arrays.sort(arr);

        for (int i = 10000000; i >= 1; i--) {
            if (arr[i] > 0) {
                k -= arr[i];
                answer++; 
            }
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }
}
