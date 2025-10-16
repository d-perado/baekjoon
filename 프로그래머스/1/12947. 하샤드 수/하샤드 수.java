class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String input = String.valueOf(x);
        
        char[] arr = input.toCharArray();
        
        int dividNum = 0;
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i] - '0';
            dividNum+=temp;
        }
        if(x%dividNum!=0){
            answer=false;
        }
        return answer;
    }
}