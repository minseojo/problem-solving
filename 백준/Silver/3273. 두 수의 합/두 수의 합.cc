#include <bits/stdc++.h>
using namespace std;

int a[100000];

int main() {
	int n, x;
	cin >> n;
	for(int i=0; i<n; i++) {
		cin >> a[i];
	}
	cin >> x;
	sort(a, a+n);
	
	int l=0, r=n-1;
	int result = 0;
	while(r>0 && l<r) {
		int sum = a[l]+a[r];
		if(sum > x) r--;
		else if(sum < x) l++;
		else {
			result++;
			r--;	
		}
	}
	cout << result;              
}