import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character,Integer> Alpha = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            for (char key : Alpha.keySet()) {
                Alpha.put(key, Alpha.get(key) + 1);
                }
            if(Alpha.get(s.charAt(i))==null){
                answer[i]=-1;
            } else {
                answer[i]=Alpha.get(s.charAt(i));
            }
            Alpha.put(s.charAt(i),0);
            
        }
        
        return answer;
    }
}