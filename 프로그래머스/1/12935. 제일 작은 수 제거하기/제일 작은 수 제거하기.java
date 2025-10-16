import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        Integer smallest = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        
        for(int a:arr){
            if(smallest>a){
                smallest=a;
            }
        }
        for(int a:arr){
            if(smallest!=a){
                list.add(a);
            }
        }
        if(!list.isEmpty()){
            answer = list.stream().mapToInt(Integer::intValue).toArray();
        }
        else{
            answer = new int[]{ -1 };
        }
        
        
        return answer;
    }
}