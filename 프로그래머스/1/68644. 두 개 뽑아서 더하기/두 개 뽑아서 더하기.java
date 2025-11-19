import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> temp = new ArrayList<Integer>();
        
        Arrays.sort(numbers);
        boolean[] check = new boolean[numbers[numbers.length-2]+numbers[numbers.length-1]+1];
        
        for(int i = 0;i < numbers.length-1; i++) {
            for(int j = i + 1;j < numbers.length; j++){
                check[numbers[i]+numbers[j]] = true;
            }
        }
        
        for(int i = 0 ; i < check.length; i++){
            if(check[i]){
                temp.add(i);
            }
        }
        
        int[] answer = new int[temp.size()];
        
        for(int i = 0; i < temp.size(); i++){
            answer[i]=temp.get(i);
        }
        
        return answer;
    }
}