class Solution { 
    static int x=0;
    static int y=0;
    
    static boolean[][] map;
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public boolean canMove(int go, int no){
        int nx = x;
        int ny = y;

        for(int i = 0; i < no; i++){
            nx += dx[go];
            ny += dy[go];

            if(ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length)
                return false;

            if(map[ny][nx]) return false;
        }

        return true;
    }

    public void move(int go, int no){
        x += dx[go] * no;
        y += dy[go] * no;
    }
    
    public int[] solution(String[] park, String[] routes) {

        map = new boolean[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                char c = park[i].charAt(j);
                if(c == 'S'){
                    x = j;
                    y = i;
                } else if(c == 'X'){
                    map[i][j] = true;
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++){
            String[] k = routes[i].split(" ");
            String dir = k[0];
            int dist = Integer.parseInt(k[1]);

            int go = -1;
            if(dir.equals("N")) go = 0;
            else if(dir.equals("S")) go = 1;
            else if(dir.equals("W")) go = 2;
            else go = 3;

            if(canMove(go, dist)){
                move(go, dist);
            }
        }

        return new int[]{y, x};
    }
}
