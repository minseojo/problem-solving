#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[10];
int check[10];

void dfs(int pos) {
	if(pos == m+1) {
		for(int i=1; i<=m; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}
	
	for(int i=1; i<=n; i++) {
		if(!check[i]) {
			check[i]=true;
			arr[pos] = i;
			dfs(pos+1);
			check[i]=false;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);	
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	dfs(1);
	
	return 0;
}