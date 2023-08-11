#include <bits/stdc++.h>
using namespace std;

int a[111111];
int psum_L[111111];
int psum_R[111111];

int main() {
	int n;
	cin >> n;
	for(int i=1; i<=n; i++) {
		cin >> a[i];
	}
	
	if(n==1) {
		cout << a[1];
		return 0;	
	}
	psum_L[1] = a[1];
	psum_R[n] = a[n];
	int answer = psum_L[1];
	for(int i=2; i<=n; i++) {
		if(psum_L[i-1]+a[i] > a[i]) psum_L[i] = psum_L[i-1] + a[i];		
		else psum_L[i] = a[i];
	}

	for(int i=n-1; i>=1; i--) {
		if(psum_R[i+1]+a[i] > a[i]) psum_R[i] = psum_R[i+1] + a[i];		
		else psum_R[i] = a[i];
	}
	for(int i=1; i<=n; i++) {
		if(answer<psum_L[i]) answer = psum_L[i];
		if(answer<psum_R[i]) answer = psum_R[i];
	}


	for(int i=1; i<n; i++) {
		if(psum_L[i]+psum_R[i+2] > answer) answer = psum_L[i]+psum_R[i+2];
	}
	cout << answer;
	return 0;
} 
