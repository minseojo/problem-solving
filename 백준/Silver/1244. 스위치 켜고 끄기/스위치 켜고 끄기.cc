#include <bits/stdc++.h>
using namespace std;

bool a[101];
 
int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}
	
	int size;
	cin >> size;
	for (int i = 0; i < size; i++) {
		int gender, x;
		cin >> gender >> x;
		// 남자
		if (gender == 1) {
			for (int j = x; j <= n; j+=x) {
				if (j % x == 0) {
					a[j] = !a[j];
				}
			}
		}

		// 여자 
		else if (gender == 2) {
			int l = x-1, r = x+1;
			a[x] = !a[x];
			while(1 <= l && r <= n) {
				if (a[l] == a[r]) {
					a[l] = !a[l];
					a[r] = !a[r];
					l--;
					r++;
				} else {
					break;
				}
			}
		}
	}
	
	for (int i = 1; i <= n; i++) {
		cout << a[i] << " ";
		if (i % 20 == 0) {
			cout << endl;
		}
	}
	return 0;
}