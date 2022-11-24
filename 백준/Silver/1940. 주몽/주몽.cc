#include <bits/stdc++.h>
using namespace std;

int a[15000];

int main() {
	// input
	int n, m;
	cin >> n >> m;
	for(int i=0; i<n; i++) cin >> a[i];

	// solve
	sort(a, a+n);	
	int l=0, r=1, answer=0;
	while(l<n) {
		int value = a[l] + a[r];
		if(r == n-1) {
			if(value == m) answer++;
			l++;
			r = l+1;
		}
		
		if(value <= m) {
			if(value == m) answer++;
			r++;
		}
		else if(value > m) {
			l++;
			r = l+1;
		}
	}
	
	cout << answer;
	return 0;
}