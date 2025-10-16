class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a==b)return a;
        long num1 = 0;
        long num2 = 0;
        if(a>b){
            num1=a;
            num2=b;
        }else{
            num1=b;
            num2=a;
        }
        
       
        answer = (num1*(num1+1)-num2*(num2-1))/2;
     
        
        
        return answer;
    }
}