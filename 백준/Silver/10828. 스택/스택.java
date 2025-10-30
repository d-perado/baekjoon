import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int[] stack;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        stack = new int[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.startsWith("push")) {
                int x = Integer.parseInt(input.split(" ")[1]);
                push(x);
            } else if (input.equals("pop")) {
                sb.append(pop()).append('\n');
            } else if (input.equals("size")) {
                sb.append(size()).append('\n');
            } else if (input.equals("empty")) {
                sb.append(empty()).append('\n');
            } else if (input.equals("top")) {
                sb.append(top()).append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void push(int x) {
        stack[size] = x;
        size++;
    }

    public static int pop() {
        if (size == 0) return -1;
        return stack[--size];
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        return size == 0 ? 1 : 0;
    }

    public static int top() {
        if (size == 0) return -1;
        return stack[size - 1];
    }
}
