class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int fullCoke = n;
        int emptyCoke = 0;
        
        
        while(emptyCoke + fullCoke >= a){
            emptyCoke += fullCoke;
            fullCoke = 0;
            fullCoke += (emptyCoke/a)*b;            
            emptyCoke -= (emptyCoke/a)*a;
            answer += fullCoke;
        }
        
        return answer;
    }
}