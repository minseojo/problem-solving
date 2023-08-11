#include <bits/stdc++.h>
using namespace std;

int v[1111111];

int main() {
	int n;
	cin >> n;
	for (int i=0; i<n; i++) {
		cin >> v[i];
	}
	sort(v, v+n);
	int left=0, right=n-1;
	long long ret=0;
	while(left<right) {
		if(v[left]>=v[right]*0.9) {
			ret+=(right-left);
			right--;
		}
		else left++;
	}
	
	cout << ret;

	return 0;
}
