class Solution {
    public String solution(String s) {

        StringBuilder sb= new StringBuilder();
        int firstSpace = 0;
        int lastSpace = 0;

        if (s.trim().length() == 0) {
            return s;
        }

        while (s.length() > 0 && s.charAt(0) == ' ') {
            firstSpace++;
            s = s.substring(1);
        }

        while (s.length() > 0 && s.charAt(s.length() - 1) == ' ') {
            lastSpace++;
            s = s.substring(0, s.length() - 1);
        }

        for (int i = 0; i < firstSpace; i++) {
            sb.append(" ");
        }
        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].length() == 0) {
                sb.append(" ");
                continue;
            }

            String first = arr[i].substring(0, 1);
            String all = arr[i].substring(1);

            if (!Character.isDigit(first.charAt(0))) {
                first = first.toUpperCase();
            }

            all = all.toLowerCase();

            sb.append(first).append(all);

            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }

        for (int i = 0; i < lastSpace; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
