import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        //사과 최대점수 k 사과에 담기는 사과갯수 m 사과점수 score
        Arrays.sort(score);
        int[] temp = new int[score.length];
        for(int i = 0;i < score.length; i++ ){
            temp[i] = score[score.length-1-i];
        }
        
        
        for(int i = m-1; i < score.length; i++){
            answer += temp[i] * m;
            i+= m-1;
        }
        
        
        
        
        return answer;
    }
}