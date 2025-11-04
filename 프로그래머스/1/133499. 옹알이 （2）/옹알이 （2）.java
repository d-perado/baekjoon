class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canSpeak = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            for (int j = 0; j < canSpeak.length; j++) {
                word = word.replace(canSpeak[j], String.valueOf(j));
            }

            boolean valid = true;

            for (int k = 0; k < word.length(); k++) {
                char c = word.charAt(k);

                if (!Character.isDigit(c)) {
                    valid = false;
                    break;
                }

                if (k > 0 && c == word.charAt(k - 1)) {
                    valid = false;
                    break;
                }
            }

            if (valid && !word.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}