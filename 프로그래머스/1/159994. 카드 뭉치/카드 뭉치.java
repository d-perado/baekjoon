class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        boolean[] cards1Check = new boolean[cards1.length];
        boolean[] cards2Check = new boolean[cards2.length];
        boolean[] goalCheck = new boolean[goal.length];
        int whatFirstCards = -1;
        for(int i = 0; i < cards1.length; i++){
            if(cards1[i].equals(goal[0])){
                cards1Check[i] = true;
                goalCheck[0] = true;
                whatFirstCards = 1;
            }
        }
        if(whatFirstCards== -1){
            for(int i = 0; i < cards2.length; i++){
            if(cards2[i].equals(goal[0])){
                goalCheck[0]=true;
                cards2Check[i]=true;
                whatFirstCards=0;
            }
        }
        }
        
        for(int i = 1; i < goal.length; i++){
            if(i-whatFirstCards%2==0){
                for(int j=0;j<cards1.length;j++){
                    if(goal[i].equals(cards1[j]) && cards1Check[j] == false){
                        cards1Check[j]=true;  
                        goalCheck[i]=true;
                    }
                }
            } else {
                for(int j=0;j<cards2.length;j++){
                    if(goal[i].equals(cards2[j]) && cards2Check[j] == false){
                        cards2Check[j] = true;  
                        goalCheck[i] = true;
                    }
                }
            }
            
        }
        for(int i = 0; i < goal.length; i++){
            if(goalCheck[i] == false) {
            answer = "No";
            break;
            }
        }
        
        return answer;
    }
}