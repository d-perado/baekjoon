class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int rc = brown + yellow;
        for (int c = 3 ; c <= Math.sqrt(rc) ; c++) {
            if (rc % c != 0) continue;

            if ((c - 2)  *  (rc / c - 2) == yellow) {
                answer[1] = c;
                answer[0] = rc / c;
            }
        }

        
        return answer;
    }
}