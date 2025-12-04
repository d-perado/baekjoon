class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        String[] WEEK = {"FRI", "SAT", "SUN", "MON","TUE", "WED", "THU"};
        
        int[] DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int monthDiff = a - 1;
        int dayDiff = b - 1;
        
        for(int i = 0; i < monthDiff; i++){
            dayDiff += DAYS[i];
        }
        
        dayDiff %= 7;
        answer = WEEK[dayDiff];
        
        
        return answer;
    }
}