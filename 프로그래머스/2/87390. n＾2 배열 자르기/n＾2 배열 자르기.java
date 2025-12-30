class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1); // 잘린 배열 길이
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            long idx = left + i; //잘린 배열의 인덱스
            int row = (int)(idx / n) + 1;
            int col = (int)(idx % n) + 1;
            answer[i] = Math.max(row, col);
        }

        return answer;
    }
}
