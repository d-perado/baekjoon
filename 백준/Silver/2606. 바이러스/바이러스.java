import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static boolean[][] map;
    static int N;
    static int M;
    static boolean[] infection;

    static int count = 0;

    static void dfs(int n) {//dfs
        infection[n] = true;
        
        for(int i = 1; i < N+1; i++){
            if(map[n][i]&&!infection[i]){
                count++;
                dfs(i);
            }
        }
        return;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        map = new boolean[N+1][N+1];
        infection = new boolean[N+1];
        
        int x;
        int y;
        StringTokenizer st;
        for(int i=0;i<M;i++){//연결관계 생성
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            map[x][y] = true;
            map[y][x] = true;
        }
        
        dfs(1);

        System.out.println(count);
        
    }
}