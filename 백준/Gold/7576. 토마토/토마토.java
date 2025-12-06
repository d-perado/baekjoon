import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int R;
    static int C;
    static int[][] box;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        box = new int[R][C];
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                box[i][j]= Integer.parseInt(st.nextToken());
                if(box[i][j]==1) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = x +dx[i];
                int ny = y +dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = box[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            
        }

        int time = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(box[i][j]==0) {
                    System.out.println(-1);
                    return;
                }
                time = Math.max(time,box[i][j]);
            }

        }
    
        System.out.println(time-1);
    }
}