class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int fullCoke = n;
        int emptyCoke = 0;
        
        
        while(emptyCoke + fullCoke >= a){ //콜라병의 총갯수가 a보다 작을 때 탈출
            emptyCoke += fullCoke; //콜라를 마셔
            fullCoke = 0; //콜라를 다 마셨어
            fullCoke += (emptyCoke/a)*b;   //빈콜라를 새 콜라로바꿔줌          
            emptyCoke -= (emptyCoke/a)*a;
            answer += fullCoke; // 새콜라를 값에 더해서 총 마실수 있는 콜라 갯수를 만들어줌.
        }
        
        return answer;
    }
}