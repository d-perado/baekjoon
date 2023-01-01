#include <iostream>
#define n 9
#define m 5
using namespace std;
 
int dx[4] = { 0, 0, -1, 1 }, dy[4] = {-1,1,0,0}, Min, ret;
char map[m+1][n+1];
 
void find(char curmap[m+1][n+1], int depth) {
    int cnt = 0;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (curmap[i][j] == 'o') ++cnt;
        }
    }
    if (Min > cnt) {
        Min = cnt;
        ret = depth;
    }
 
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (curmap[i][j] == 'o') {
                for (int k = 0; k < 4; ++k) {
                    int xx = i + dx[k], yy = j + dy[k];
                    int xxx = i + (2 * dx[k]), yyy = j + (2 * dy[k]);
                    if (xx < 0 || xxx < 0 || xx >= m || xxx >= m || yy < 0 || yyy < 0 || yy >= n || yyy >= n) continue;
                    if (curmap[xx][yy] == 'o' && curmap[xxx][yyy] == '.') {
                        curmap[i][j] = '.';
                        curmap[xx][yy] = '.';
                        curmap[xxx][yyy] = 'o';
                        find(curmap, depth + 1);
                        curmap[i][j] = 'o';
                        curmap[xx][yy] = 'o';
                        curmap[xxx][yyy] = '.';
                    }
                }
            }
        }
    }
}
 
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        Min = 987654321, ret = -1;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                cin >> map[i][j];
 
        find(map, 0);
        cout << Min << " " << ret << '\n';
    }
    return 0;
}
