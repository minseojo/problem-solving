#include <bits/stdc++.h>
using namespace std;

struct Point {
	int volume; // 현재 볼륨 
	int index; // 현재 인덱스 
};
int N, S, M;
int a[50];
bool visited[51][1001];
bool isLastDance = true;
int ans;

void BFS() {
	queue<Point> q;
	q.push({S, 0});
	visited[0][S] = true;
	
	while (!q.empty()) {
		int size = q.size();
		int dance_cnt = 0;
		while (size--) {
			int volume = q.front().volume;
			int index = q.front().index;
			int dif = a[index];
			q.pop();
			
			if (index == N && !visited[index][volume]) {
				visited[index][volume] = true;
				dance_cnt++;
				ans = max(ans, volume);
				continue;
			}

			if (volume - dif >= 0 && !visited[index][volume - dif]) {
				visited[index][volume - dif] = true;
				q.push({volume - dif, index + 1});
				dance_cnt++;
			}
			
			if (volume + dif <= M && !visited[index][volume + dif]) {
				visited[index][volume + dif] = true;
				q.push({volume + dif, index + 1});
				dance_cnt++;
			}
		}
		if (dance_cnt == 0) {
			isLastDance = false;
			return;
		}
	}
	
}

int main() {
	cin >> N >> S >> M;
	for (int i = 0; i < N; i++) {
		cin >> a[i];
	}
	BFS();
	if (isLastDance) cout << ans << "\n";
	else cout << -1 << "\n";
	return 0;
}