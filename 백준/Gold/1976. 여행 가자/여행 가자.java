import java.io.*;
import java.util.*;

public class Main { 
    static int[] parent;
    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return false;
        if(x < y){
            parent[y] = x;
        } else {
            parent[x] = y;
        }
        return true;
    }
    
    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        Integer N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        
        for(int i = 1; i < N+1; i++) {
            parent[i] = i;
        }
        Integer M = Integer.parseInt(br.readLine());
        
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<N+1;j++){
                if(i==j) break;
                if(Integer.parseInt(st.nextToken())==1){
                    union(i,j);
                }
            }
            
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        boolean flag = true;
        while(st.hasMoreTokens()){
            if(find(k)!=find(Integer.parseInt(st.nextToken()))){
                flag=false;
                break;
            }
        }
        System.out.println(flag?"YES":"NO");
    }
}