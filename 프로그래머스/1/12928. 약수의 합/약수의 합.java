import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n==1)return 1;
        if(n==0)return 0;
        int lastNum=n;
        
        for(int i=1;i<lastNum;i++){
            if(n%i==0){
                if(i==n/i){answer+=i;
                          break;}
                answer=answer+i+n/i;
                lastNum=n/i;
            }
        }

        return answer;
    }
}