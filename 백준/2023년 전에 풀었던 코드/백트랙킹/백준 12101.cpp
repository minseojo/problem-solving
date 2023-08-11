#include <bits/stdc++.h>
using namespace std;

int n, k, cnt=0;
vector<int> v;
	
void dfs(int sum) {
	if(sum>n) return;
	
	if(sum==n) {
		cnt++;
		if(cnt==k) {
			for(int i=0; i<v.size(); i++) { 
				if(i==v.size()-1) cout << v[i]; 
				else cout << v[i] << "+"; 
			}
		}
		return;
	}
	
	for(int i=1; i<=3; i++) { 
		v.push_back(i); 
		dfs(sum+i); 
		v.pop_back(); 
	}
}

int main() {
	cin >> n >> k;	
	
	dfs(0);	
	if(cnt==0 || cnt<k) cout << -1;
	return 0;
}
