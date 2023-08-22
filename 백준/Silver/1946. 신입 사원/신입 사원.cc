#include <bits/stdc++.h>
using namespace std;

struct Record {
	int a;
	int b;
};

bool comp(const Record& a, const Record& b) {
	return a.a < b.a;
}
vector<Record> v;

int main() {
	int tc;
	cin >> tc;
	while(tc--) {
		int n;
		cin >> n;
		for (int i = 0; i < n; i++) {
			int a, b;
			cin >> a >> b;
			v.push_back({a, b});
		}
		sort(v.begin(), v.end(), comp);
		
		int ans = n;
		int b = v[0].b;
		for (int i = 1; i < v.size(); i++) {
			if (b < v[i].b) {
				ans--;
			} else {
				b = v[i].b;
			}
		}
		cout << ans << endl;
		v.clear();
	}
	return 0;
}