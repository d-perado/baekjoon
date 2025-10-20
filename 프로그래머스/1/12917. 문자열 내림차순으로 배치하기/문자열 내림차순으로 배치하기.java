import java.util.*;

class Solution {
    public static String solution(String s) {
        String answer = "";
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length-1;i++){
            for (int j = 0; j < charArray.length-1-i; j++) {
                if(charArray[j]<charArray[j+1]){
                    char temp = charArray[j];
                    charArray[j]=charArray[j+1];
                    charArray[j+1]=temp;
                }
            }
        }

        for(char arr : charArray){
            answer+=arr;
        }

        return answer;
    }
}