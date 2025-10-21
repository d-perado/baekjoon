class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for(int i=0;i<number.length;i++){
            for(int j=0;j<i;j++){
                for(int k=0;k<j;k++){
                    if(number[i]+number[j]+number[k]==0){
                        answer ++;
                    }
                }
            }
        }
        
        return answer;
    }
}