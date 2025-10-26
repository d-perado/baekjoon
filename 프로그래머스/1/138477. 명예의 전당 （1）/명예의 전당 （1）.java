import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        int[] bestScore = new int[k];
        Arrays.fill(bestScore,-1);
        for(int i = 0; i < score.length; i++) {
            if(bestScore[0] < score[i]) {
                bestScore[0] = score[i];
            }
            
            Arrays.sort(bestScore);
            
            for(int j = 0; j < k; j++) {
                if (bestScore[j] == -1) {
                    continue;
                } else {
                    answer[i] = bestScore[j];
                    break;
                }
            }
            
            Arrays.sort(bestScore);
            
        }
        
        return answer;
    }
    
}