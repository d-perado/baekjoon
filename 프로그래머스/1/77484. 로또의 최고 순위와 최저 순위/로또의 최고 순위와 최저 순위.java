class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt=0;
        int confirm=0;
        int[] rank = { 6, 6, 5, 4, 3, 2,1};
        for(int i=0;i<lottos.length;i++){
            for(int j=0;j<win_nums.length;j++){
                if(lottos[i]==0){
                    zeroCnt++;
                    break;
                }
                if(lottos[i]==win_nums[j]){
                    confirm++;
                }
            }
        }
        answer[0]=rank[zeroCnt+confirm];
        answer[1]=rank[confirm];
        
        
        return answer;
    }
}