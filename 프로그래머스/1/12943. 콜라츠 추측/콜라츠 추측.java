class Solution {
    public int solution(int num) {
        int answer = 0;
        long cal = num;
        while(cal!=1){
            if(answer==500){return -1;}
            if(cal%2==0){
                cal /= 2;
                
            } else{
                cal=cal*3+1;
            }
            answer++;
            
        }
        
        return answer;
    }
}