#include <bits/stdc++.h>
using namespace std;

int n;
bool visited[11111];
int ans=0;
int loma[4] ={1,5,10,50};

void solve(int idx, int start, int sum) {
	if(idx==n) {
		if(!visited[sum]) {
			ans++;
			visited[sum]=true;
		}
		return;
	}

	for(int i=start; i<4; i++) {
		solve(idx+1, i, sum+loma[i]);
	}
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
	cin >>n;

	solve(0, 0, 0);
	cout<<ans;
	return 0;	
}
