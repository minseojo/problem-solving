#include <bits/stdc++.h>
using namespace std;

int n;
vector<pair<int, int > > v;
int ans=0;

void dfs(int index, int sum) {
	if(index>=n) {
		ans = max(ans, sum);
		return;
	}
	
	dfs(index+1, sum);
	if(index+v[index].first <= n) {
		dfs(index+v[index].first, sum+v[index].second);
	}
}

int main() {	
	int a, b;
	cin >> n;
	for(int i=0; i<n; i++) {
		cin >> a >> b;
		v.push_back({a, b});
	}
	dfs(0, 0);
	
	cout << ans;
	return 0;
}
