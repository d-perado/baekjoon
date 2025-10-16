import java.util.*;

class Solution {
    public long solution(long n) {
        long answer;
        String strNum = String.valueOf(n);
        char[] than = strNum.toCharArray();
        String thanthan="";
        char pivot = '0';
        for(int j=0;j<than.length;j++){
            boolean[] checked = new boolean[than.length];
            int k=0;
            for(int i = 0;i < than.length; i++){
                if(than[i]>pivot&&!checked[i]){
                    pivot=than[i];
                    checked[i]=true;
                    k= i;
                }
            }
            than[k]='0';
            thanthan+=pivot;
            pivot='0';
        }
        answer= Long.parseLong(thanthan);
        return answer;
    }
}