#include <bits/stdc++.h>
using namespace std;

int N, M;
int visited[10001];
vector<int> number;
vector<int> cache;

void solve(int pos) {
	if(pos == M) {
		for(int i = 0; i < cache.size(); i++) {
			cout << cache[i] << " ";
		}
		
		cout << "\n";
		return;
	}

	for(int i = 0; i < number.size(); i++) {
		cache.push_back(number[i]);
		solve(pos + 1);
		cache.pop_back();
	}
}

int main() {
	cin >> N >> M;
	
	int num;
	for(int i = 0; i < N; i++) {
		cin >> num;
		if(visited[num] != 1) {
			visited[num] = 1;
			number.push_back(num);
		}
	}
	
	sort(number.begin(), number.end());
	solve(0);
} 
