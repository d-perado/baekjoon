import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int[] queue;
    static int minIdx = 0;
    static int maxIdx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        queue = new int[n];

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
            } else if (input.equals("front")) {
                sb.append(front()).append('\n');
            } else if(input.equals("back")){
                sb.append(back()).append('\n');
            }
        }

        System.out.print(sb);
    }


    public static void push(int i) {
        queue[maxIdx] = i;
        maxIdx++;
    }

    public static int pop() {
        if(empty() == 1) return -1;
        return queue[minIdx++];
    }

    public static int front() {
        if(empty() == 1) return -1;
        return queue[minIdx];
    }

    public static int back(){
        if(empty() == 1) return -1;
        return queue[maxIdx-1];
    }

    public static int size(){
        return maxIdx-minIdx;
    }

    public static int empty(){
        if(minIdx == maxIdx) return 1;
        return 0;
    }


}