import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < input; i++) {
            List<String> arr = new ArrayList<>();
            Stack<String> stack = new Stack<>();
            String input2 = sc.nextLine();

            String[] arr2= input2.split(" ");

            for(int j=0;j< arr2.length;j++){
                stack.push(arr2[j]);
            }
            StringBuilder print = new StringBuilder("Case #" + (i + 1) + ": ");
            while(!stack.empty()){
                print.append(stack.pop()).append(" ");

            }
            System.out.println(print);
        }

    }
}