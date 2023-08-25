#include <bits/stdc++.h>
using namespace std;

int main() {
	int tc;
	cin >> tc;
	while (tc--) {
		int sy, sx, ey, ex, n;
		cin >> sy >> sx >> ey >> ex;
		cin >> n;
		int s_cnt = 0, e_cnt = 0;
		for (int i = 0; i < n; i++) {
			int y, x, r;
			cin >> y >> x >> r;
			r *= r;
			int r1 = pow(sy-y, 2) + pow(sx-x, 2);
			int r2 = pow(ey-y, 2) + pow(ex-x, 2);
			if (r1 < r && r2 > r) s_cnt++;
			else if (r1 > r && r2 < r) e_cnt++;
		}
		cout << s_cnt + e_cnt << endl;
	}
	return 0;
}