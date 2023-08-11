#include <bits/stdc++.h>
using namespace std;

int n;
int a[1111111];
int cache[1111111];

int solve(int start) {
	int &ret=cache[start+1];
	if(ret!=-1) return ret;
	
	ret=0;  
	for(int i=start+1; i<n; i++) {
		if(start==-1 || a[start]<a[i]) {
			ret = max(ret, solve(i)+1);
		}
	}
	
	return ret;
}

int main() {
	cin >> n;
	for(int i=0; i<n; i++) {
		cin >> a[i];
	}
	
	memset(cache, -1, sizeof(cache));
	cout << solve(-1) << "\n";
	
	for(int i=0; i<=n; i++) {
		cout << cache[i] <<  " ";
	}
	return 0;
} 
