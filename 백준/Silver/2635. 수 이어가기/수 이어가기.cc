#include <bits/stdc++.h>
using namespace std;

int main(){ 
	int n;
	cin >> n;
	int idx = 0, max_cnt = 0;
	for (int i = 1; i <= n; i++) {
		int a = n, b = i, x = 0;
		int cnt = 1;
		while(x >= 0) {
			cnt++;
			x = a-b;
			a = b;
			b = x;
		}
		if (cnt > max_cnt) {
			idx = i;
			max_cnt = cnt;
		}
	}
	
	int a = n, b = idx, x = a-b;
	cout << max_cnt << endl;
	cout << a << " " << b << " ";
	while(x >= 0) {
		cout << x << " ";
		a = b;
		b = x;
		x = a-b;
	}
}