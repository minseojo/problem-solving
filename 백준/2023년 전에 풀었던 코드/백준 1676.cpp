#include <bits/stdc++.h>
using namespace std;
int a[501];

int main() {
	int n, cnt=0, zero=1;
	cin >> n;
	for(int i=5; i<=500; i++) {
		a[i] = zero;
		cnt++;
		if(cnt%5==0) zero++;
	}
	cout << a[n];
	
	return 0;
}
