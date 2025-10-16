class Solution {
    public long solution(long n) {
        long answer = 0;
        long temp;
        temp=(long)(Math.sqrt(n));
        Math.floor(temp);
        if(Math.pow(temp,2)!=n){
            return -1;
        }
        return (long)(Math.pow(temp+1,2));
    }
}