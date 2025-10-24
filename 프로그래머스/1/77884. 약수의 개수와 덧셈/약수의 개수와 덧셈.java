
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int count = 0;
        for(int i = left; i <right+1 ;i++){
                if(i==1){
                    answer-=1;
                    continue;}
                
            for(int j=1;j<i/2+1;j++){
                if(i % j == 0){
                    if(i/j==j){
                        count++;
                    }else{
                        count+=2;
                     }
                }
            }
            if(count%2==0){
                answer+=i;
            }else{
                answer-=i;
            }
            count=0;
        }
        
        return answer;
    }
}