class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int bigger = 0 ;
        int smaller = 0;
        int md=0;
        int sm=0;
        if(n==m){
            answer[0]=n;
            answer[1]=n;
        } else if(n>m){
            bigger=n;
            smaller=m;
        }else{
            smaller=n;
            bigger=m;
        }
        
        for(int i=1; i <= smaller;i++){
            if(bigger%i==0&&smaller%i==0){
                md=i;
            }
        }
        sm=smaller*bigger/md;
        
        answer[0]=md;
        answer[1]=sm;
        
        return answer;
    }
}