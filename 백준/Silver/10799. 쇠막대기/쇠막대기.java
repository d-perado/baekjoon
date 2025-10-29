import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < input.length(); i++) { //바를 판별하자
            if(input.charAt(i)=='('){
                stack.push('(');
            } else {
                stack.pop();
                if(input.charAt(i-1)==')'){
                    answer++;
                } else {
                    answer += stack.size();
                }
            }


        }
        System.out.println(answer);
    }
}



