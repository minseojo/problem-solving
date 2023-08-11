#include <bits/stdc++.h>
using namespace std;

int n;
int a[1111111];
int cache[1111111];
vector<int> v;

void binary_search(int x) {
	int left=0, right=v.size(), mid=0;
	int index=1e9;
	while(left<=right) {
		mid=(left+right)/2;
		int num = v[mid];
		if(num >= x) {
			if(index> mid) {
				index=mid;
			}
			right=mid-1;
		} else {
			left=mid+1;
		}
	}
	
	v[index]=x;
}

void solve() {
	v.push_back(a[0]);
	
	for(int i=1; i<n; i++) {
		if(v.back() < a[i]) {
			v.push_back(a[i]);
		} else {
			binary_search(a[i]);
		}
	}
}

int main() {
	cin >> n;
	for(int i=0; i<n; i++) {
		cin >> a[i];
	}
	
	solve();
	cout << v.size() << "\n";
	for(int i=0; i<v.size(); i++) {
		cout << v[i] << " ";
	} 
	return 0;
} 
