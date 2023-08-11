#include <bits/stdc++.h>
#define MAX 300
#define INF 987654321
using namespace std;

typedef struct {
	int y, x;
}Dir ;

Dir move[8] = {{1,2}, {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};
int cache[MAX][MAX];
bool visited[MAX][MAX];

int bfs(int n, int y, int x, int dy, int dx) {
	queue<pair<int, int> > q;
	q.push(make_pair(y, x));
	cache[y][x]=0;
	
	while (!q.empty()) {
		pair<int, int> currentPos= q.front();
		q.pop();
		if(currentPos.first == dy&& currentPos.second == dx) return cache[dy][dx];
		for(int i=0; i<8; i++) {
			int ny = currentPos.first + move[i].y;
			int nx = currentPos.second + move[i].x;
			if(nx >= 0 && ny >= 0 && nx < n &&  ny < n && !visited[ny][nx]) {
				q.push(make_pair(ny ,nx));
				visited[ny][nx]=true;
				cache[ny][nx] = min(cache[ny][nx], cache[currentPos.first][currentPos.second]+1);
			}
		}
	}
}

int main() {
	int tc, n;
	cin >> tc;
	while(tc--) {
		memset(visited, false, sizeof(visited));
		int y, x, dy, dx;
		for(int i=0; i<MAX; i++) {
			for(int j=0; j<MAX; j++) {
				cache[i][j] = INF;
			}
		}
		cin >> n >> y >> x >> dy >> dx;
		cout << bfs(n, y, x, dy, dx) << endl;
	}
}
