#include <bits/stdc++.h>
using namespace std;

vector<int> v;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int n, x;
	cin >> n;
	
	for(int i=0; i<n; i++) {
		cin >> x;
		if(i==0) {
			v.push_back(x);
			continue;
		}
		if(v.back()>=x) {
			auto iter = lower_bound(v.begin(), v.end(), x);
			*iter=x;
		} else {
			v.push_back(x);
		}
	}
	cout << v.size();
}