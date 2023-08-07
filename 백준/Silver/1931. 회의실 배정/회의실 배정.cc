#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct St {
	int start;
	int end;
};

vector<St> v;
bool comp(St &a, St &b) {
	if (a.end == b.end) return a.start < b.start;
	return a.end < b.end;
}

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int start, end;
		cin >> start >> end;
		v.push_back({start, end});
	}
	sort(v.begin(), v.end(), comp);
	int ans = 1, e = v[0].end;
	for (int i = 1; i < n; i++) {
		if (v[i].start >= e) {
			e = v[i].end;
			ans++;
		}
	}
	cout << ans;
	return 0;
}