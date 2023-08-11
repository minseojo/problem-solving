#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> port;
vector<int> link;

void solve() {
	link.push_back(port[0]);
	 
	for(int i=1; i<n; i++) {
		int x = port[i];
		
		if(link.back() > x) {
			auto iter = lower_bound(link.begin(), link.end(), x);
			*iter = x;
		} else {
			link.push_back(x);
		}
	}
	
	cout << link.size();
}

int main() {
	cin >> n;
	for(int i=0; i<n; i++) {
		int num;
		cin >> num;
		port.push_back(num);
	}
	
	solve();
}
