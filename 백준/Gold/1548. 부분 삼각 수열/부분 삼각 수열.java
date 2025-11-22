import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) a[i] = Integer.parseInt(st.nextToken());

        if(N<3){
            System.out.println(N);
            return;
        }

        Arrays.sort(a);
        int ans = 2;
        int left = 0;
                        
        for(int right = 2; right < N; right++){
            while(left < right-1 && a[left] + a[left+1] <= a[right]){
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        System.out.println(ans);
    }
}