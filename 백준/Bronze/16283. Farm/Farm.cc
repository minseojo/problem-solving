#include <bits/stdc++.h>
using namespace std;

struct Point {
	int a;
	int b;
};

const int MAX = 1000;
vector<Point> ans;

int main() {
	int a, b, n , w;
	cin >> a >> b >> n >> w;
	
	for (int i = 1; i < n; i++) {
		if (a * i + (n - i) * b == w) {
			ans.push_back({i, n - i});
		}
	}

	if (ans.empty() || ans.size() > 1) cout << -1;
	else cout << ans[0].a << " " << ans[0].b;
	return 0;
}