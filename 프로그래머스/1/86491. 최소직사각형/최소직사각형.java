import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        for(int i= 0 ; i<sizes.length;i++){
            Arrays.sort(sizes[i]);
        }
        int maxw=0;
        int maxh=0;
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0]>maxw){
                maxw=sizes[i][0];
            }
            if(sizes[i][1]>maxh){
                maxh=sizes[i][1];
            }
        }
        return maxh*maxw;
    }
}