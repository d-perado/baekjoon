import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    stack.push(s.charAt(j));
                } else {
                    if(stack.empty()){
                        isValid = false;
                        break;
                    }
                        stack.pop();
                }
            }
            if(!stack.empty()) isValid = false;

            System.out.println(isValid ? "YES":"NO");

        }
    }
}