#include <bits/stdc++.h>
using namespace std;

int N, M;
int city[50][50];
vector<pair<int, int>> chicken;
vector<pair<int, int>> home;
vector<pair<int, int>> cache;
int answer=1e9;

void input() {
	cin >> N >> M;
	for(int i=0; i<N; i++) {
		for(int j=0; j<N; j++) {
			cin >> city[i][j];
			if(city[i][j]==1) home.push_back({i, j});
			else if(city[i][j]==2) chicken.push_back({i, j});
		}
	}
}

int findShortPath() {
	int result = 0;
	for(int i=0; i<home.size(); i++) {
		int dis = 1e9;
		for(int j=0; j<cache.size(); j++) {
			int dis2 = abs(home[i].first-cache[j].first) + abs(home[i].second-cache[j].second);
			dis = min(dis, dis2);
		}
		result += dis;
	}
	return result;
}

void solve(int pos, int here) {
	if(pos==M) {
		for(int i=0; i<M; i++) {
			answer = min(answer, findShortPath());
		}
		return;
	}
	
	for(int i=here; i<chicken.size(); i++) {
		int y = chicken[i].first;
		int x = chicken[i].second;
		cache.push_back({y, x});
		solve(pos+1, i+1);
		cache.pop_back();
	}
}

int main() {
	input();
	solve(0, 0);
	cout << answer;
	return 0;
}
