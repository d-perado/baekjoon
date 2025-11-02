class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] wall = new boolean[n+1];
        
        for(int i=0;i<section.length;i++){
            wall[section[i]] = true;
        }
        for(int i=1;i<n+1;i++){
            if(wall[i]==true){
                answer++;
                for(int j=0;j<m;j++){
                    if(i+j>=n+1){
                        break;
                    }
                    wall[i+j]=false;
                }
            }
        }
        
        return answer;
    }
}