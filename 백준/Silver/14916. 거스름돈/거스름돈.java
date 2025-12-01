import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = {2, 1, 3, 2}; // 규칙찾기
        
        int answer = 0;
        if (N == 1) {
            answer = -1;
        } else if (N == 2) {
            answer = 1;
        } else if (N == 3) {
            answer = -1;
        } else if (N == 4) {
            answer = 2;
        } else if (N % 5 == 0){
            answer = N / 5;
        } else {
            int a = N / 5;
            int b = N % 5;
            answer= a + arr[b-1];
        }

        
        System.out.println(answer);
    }
}
