#include <bits/stdc++.h>
using namespace std;

int N, T;
int need[101];
int value[101];
int cache[101][10001];

void init() {
	cin >> N >> T;
	for(int i=0; i<N; i++) {
		cin >> need[i] >> value[i];
	}
}

int dfs(int here, int time) {
	if(here == N) return 0;
	int &ret = cache[here][time];
	if(ret != -1) return ret;
	ret = dfs(here+1, time);
	
	if(time-need[here] >= 0) {
		ret = max(ret, dfs(here+1, time-need[here]) + value[here]);
	}
	
	return ret;
}

void solution() {
	memset(cache, -1, sizeof(cache));
	cout << dfs(0, T);
	
}

int main() {
	init();
	solution();
	
	return 0;	
}