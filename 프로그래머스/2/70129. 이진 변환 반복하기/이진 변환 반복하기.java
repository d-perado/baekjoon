class Solution {
    public int[] solution(String s) {
        int count = 0; // 변환 횟수
        int zero = 0;  // 제거된 0의 개수

        while (!s.equals("1")) {
            count++;

            int before = s.length();
            s = s.replace("0", "");
            int after = s.length();

            zero += (before - after);

            s = Integer.toBinaryString(after);
        }

        return new int[]{count, zero};
    }
}
