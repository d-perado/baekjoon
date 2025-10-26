class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=1;i<food.length;i++){
            while(food[i]>1){
                answer += i;
                food[i] -= 2;
            }
        }
        String temp = answer;
        answer += 0;
        for(int i = 0; i < temp.length();i++){
            answer += temp.charAt(temp.length()-i-1);
        }
        
        return answer;
    }
}