class Solution {
    
    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[1000000];    
        
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i < n + 1; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }
        answer = (int)dp[n-1];
        
        return answer;
    }
}