#include <bits/stdc++.h>
using namespace std;

struct Country {
	int country; // 나라 
	int a; // 금메달 
	int b; // 은메달 
	int c; // 동메달
	int rank;
};
vector<Country> v;

int cur_rank = 1, total_rank = 1;

bool comp(const Country &a, const Country &b) {
	if (a.a == b.a) {
		if (a.b == b.b) {
			return a.c > b.c;
		}
		return a.b > b.b;
	}
	return a.a > b.a;
}
int main() {

	int n, k;

	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		int country, a, b, c;
		cin >> country >> a >> b >> c;
		v.push_back({country, a, b, c, -1});
	}
	sort(v.begin(), v.end(), comp);
	
	v.at(0).rank = cur_rank;
	for(int i = 1; i < v.size(); i++) {
		if (v.at(i).a == v.at(i-1).a && v.at(i).b == v.at(i-1).b && v.at(i).c == v.at(i-1).c) {
			v.at(i).rank = cur_rank;
			total_rank++;
		} else {
			total_rank++;
			cur_rank = total_rank;
			v.at(i).rank = cur_rank;
		}
	}
	
	for (Country c : v) {
		if(c.country == k) {
			cout << c.rank;
			return 0;
		}
	}

	return 0;
}