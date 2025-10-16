import java.util.ArrayList;

class Solution {
    public ArrayList solution(long n) {
        ArrayList<Integer> answer = new ArrayList<>();
        while(true){
            answer.add((int)(n%10));
            if(n<10)break;
            n/=10;
        }
        return answer;
    }
}