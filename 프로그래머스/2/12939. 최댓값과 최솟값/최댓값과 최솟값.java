import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] a = s.split(" ");
        
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        
        for(int i=0;i<a.length;i++){
            if(Integer.parseInt(a[i])>max){
                max = Integer.parseInt(a[i]);
            }
            if(Integer.parseInt(a[i])<min){
                min = Integer.parseInt(a[i]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        
        answer = sb.toString();
        
        return answer;
    }
}