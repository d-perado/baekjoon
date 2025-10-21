class Solution {
    public int solution(String s) {
     
        String[] n = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i = 0; i < n.length; i++){
            s = s.replace(n[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
