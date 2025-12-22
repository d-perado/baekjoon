class Solution {
    public long solution(int n) {
        long answer = 0;
        int[] k = new int[2001];
        k[1]=1;
        k[2]=2;
        
        for(int i=3;i<n+1;i++){
          k[i]=(k[i-1]+k[i-2])%1234567;
            
            
        }
        
        answer=k[n];
        
        
        return answer;
    }
}