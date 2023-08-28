#include <bits/stdc++.h>
using namespace std;

struct Point {
	int need;
	int limit_time;
};

int N;
vector<Point> v;

bool comp(Point& a, Point& b) {
	if (a.limit_time == b.limit_time) a.need < b.need;
	return a.limit_time < b.limit_time;
}

int main() {
	cin >> N;
	
	int need = 0, limit_time = 0;
	for (int i = 0; i < N; i++) {
		cin >> need >> limit_time;
		v.push_back({need, limit_time});
	}
	
	sort (v.begin(), v.end(), comp);
	int cur_time = v[N-1].limit_time;
	for (int i = N-1; i >= 0; i--) {
		need = v[i].need;
		limit_time = v[i].limit_time;
		
		if (cur_time > limit_time) cur_time = limit_time - need;
		else cur_time -= need;
	}
	
	if (cur_time < 0) cur_time = -1;
	cout << cur_time << "\n";
	return 0;
}