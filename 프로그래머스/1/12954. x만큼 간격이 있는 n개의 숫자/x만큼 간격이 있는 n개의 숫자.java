import java.util.ArrayList;

class Solution {
    public ArrayList solution(int x, int n) {
        ArrayList<Long> answer= new ArrayList<>();
        for(long i = 0;i<n;i++){
            answer.add(x+i*x);
        }
        return answer;
    }
}