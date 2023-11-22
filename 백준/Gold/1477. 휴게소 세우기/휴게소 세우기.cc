#include <bits/stdc++.h>
using namespace std;

vector<int> v;

int main() {
	int N, M, L;
	cin >> N >> M >> L;
	for (int i = 0; i < N; i++) {
		int here;
		cin >> here;
		v.push_back(here);
	}
	v.push_back(0);
	v.push_back(L);
	sort(v.begin(), v.end());
	
	int l = 1, r = L-1;
	while (l <= r) {
		int m = (l+r)/2;
		int cnt = 0;
		for (int i = 1; i < v.size(); i++) {
			int dist  = v[i] - v[i-1];
			if (dist % m == 0) cnt += (dist/m -1);
			else cnt += (dist/m);
		}

		if (cnt > M) l = m+1; 
		else r = m-1;
	}
	
	cout << l;
	
	return 0;
}