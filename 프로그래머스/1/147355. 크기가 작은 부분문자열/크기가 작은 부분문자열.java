class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        Long b= Long.parseLong(p);
        for(int i=0 ;i <t.length()-p.length()+1;i++){
            if(t.length()==1){
                if(t.equals(p))return 1;
            }
            Long a = Long.parseLong(t.substring(i,i+p.length()));
            if(b>=a){
                answer++;
            }
            
        }
        
        return answer;
    }
}