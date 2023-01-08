#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int a[101][101];
//동서남북
const int dy[4] = { 0,0,1,-1 };
const int dx[4] = { 1,-1,0,0 };
int n, m;
int fy, fx, fd;
int ey, ex, ed;
int dis[101][101][4];
struct g {
	int y, x, dir;
};
int bfs()
{
	queue<g> q;
	q.push({ fy,fx,fd });
	dis[fy][fx][fd] = 0;

	while (!q.empty()) {

		int y = q.front().y;
		int x = q.front().x;
		int dir = q.front().dir;

		q.pop();

		if (y == ey && x == ex && dir == ed) {
			return dis[y][x][dir];
		}

		//현재 방향으로 1,2,3만큼 움직이기
		for (int k = 1; k <= 3; ++k) {
			int ny = y + dy[dir] * k;
			int nx = x + dx[dir] * k;
			
			if (dis[ny][nx][dir] != -1)continue;

			if (0 <= ny && ny < n && 0 <= nx && nx < m && a[ny][nx] == 0) {
				dis[ny][nx][dir] = dis[y][x][dir] + 1;
				q.push({ ny,nx,dir });
			}
			else
				break;

		}
		//방향 바꾸기 
		if (dir == 0 || dir == 1) {
			int ndir = 2;
			if (dis[y][x][ndir] == -1) {
				dis[y][x][ndir] = dis[y][x][dir] + 1;
				q.push({ y,x,ndir });
			}
			ndir = 3;
			if (dis[y][x][ndir] == -1) {
				dis[y][x][ndir] = dis[y][x][dir] + 1;
				q.push({ y,x,ndir });
			}
		}
		if (dir == 2 || dir == 3) {
			int ndir = 1;
			if (dis[y][x][ndir] == -1) {
				dis[y][x][ndir] = dis[y][x][dir] + 1;
				q.push({ y,x,ndir });
			}
			ndir = 0;
			if (dis[y][x][ndir] == -1) {
				dis[y][x][ndir] = dis[y][x][dir] + 1;
				q.push({ y,x,ndir });
			}
		}

	}
	return -1;
}
int main() {

	cin >> n >> m;

	memset(dis, -1, sizeof(dis));

	for (int i = 0; i < n; ++i)
		for (int j = 0; j < m; ++j) {
			cin >> a[i][j];
		}

	cin >> fy >> fx >> fd;
	fy -= 1; fx -= 1; fd -= 1;
	cin >> ey >> ex >> ed;
	ey -= 1; ex -= 1;  ed -= 1;
	cout << bfs() << "\n";

	return 0;
}