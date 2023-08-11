#include <bits/stdc++.h>
using namespace std;

int V, E;
vector<int> a[10001];
int discoverd[10001];
int isCut[10001];
int cnt=0;

int solve(int here, bool isRoot) {
	discoverd[here]=++cnt;
	int ret=discoverd[here];
			
	int child=0;
	for(int i=0; i<a[here].size(); i++) {
		int next=a[here][i];
		if(discoverd[next]==-1) {
			child++;
			int x=solve(next, false);
			if(!isRoot && x>=discoverd[here]) {
				isCut[here]=1;
			}
			ret=min(ret, x);
		} else {
			ret=min(ret, discoverd[next]);
		}
	}
	
	if(isRoot && child>=2) {
		isCut[here]=1;
	}
	return ret;
}

int main() {
	cin >> V >> E;
	
	int u, v;
	for(int i=0; i<E; i++) {
		cin >> u >> v;
		a[u].push_back(v);
		a[v].push_back(u);
	}
	
	memset(discoverd, -1, sizeof(discoverd));
	for(int i=1; i<=V; i++) {
		if(discoverd[i]==-1) solve(i, true);
	}
	
	int answer=0;
	for(int i=1; i<=V; i++) {
		if(isCut[i]) answer++;
	}
	
	cout << answer << "\n";
	for(int i=1; i<=V; i++) {
		if(isCut[i]) cout << i << " ";
	}
	
	return 0;
}
