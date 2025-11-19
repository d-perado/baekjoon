import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer=0;
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int j = 0; j < M; j++) {
            for(int m = j + 1; m < M; m++) {
                for(int n = m + 1; n < M; n++) {
                    int sum = 0;
                    for(int i = 0; i < N; i++) {    
                        int max = Math.max(arr[i][j],Math.max(arr[i][m],arr[i][n]));
                        sum+= max;
                    }
                    answer=Math.max(answer,sum);
             }
        }
    } 

      
        System.out.println(answer);
    }
}
