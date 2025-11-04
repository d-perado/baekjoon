class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] xCnt = new int[10];
        int[] yCnt = new int[10];
        for(int i = 0;i<X.length();i++){
            xCnt[X.charAt(i)-'0']++;
        }
        for(int i = 0;i<Y.length();i++){
            yCnt[Y.charAt(i)-'0']++;
        }
        
        for(int i=9;i>0;i--){
            for(int j=0;j<Math.min(yCnt[i],xCnt[i]);j++){
                answer.append(i);
            }
        }
        if(answer.length()==0&&Math.min(yCnt[0],xCnt[0])>0) return "0";
        if(answer.length()==0&&Math.min(yCnt[0],xCnt[0])==0) return "-1";
        for(int i=0;i<Math.min(yCnt[0],xCnt[0]);i++){
            answer.append(0);
        }
        return answer.toString();
    }
}