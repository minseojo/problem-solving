#include <bits/stdc++.h>
using namespace std;

struct St{
	int dist;
	int size;
};
bool comp(St&a , St& b) {
	return a.dist > b.dist;
}
bool comp2(St&a , St& b) {
	return a.dist > b.dist;
}
vector<St> v; // 음수 
vector<St> v2; // 양수 
int main() {
	int n, k, s; // 단지, 통학버스, 학교위치 
	cin >> n >> k >> s;
	for (int i = 0; i < n; i++) {
		int idx, value;
		cin >> idx >> value;
		if (idx-s == 0) continue;
		else if (idx-s < 0) v.push_back({s-idx, value});	
		else v2.push_back({idx-s, value});
	}
	sort(v.begin(), v.end(), comp);
	sort(v2.begin(), v2.end(), comp2);
	
	int ans = 0, max_dist = -1e9, size = 0;
	for (int i = 0 ; i < v.size(); i++) {
		max_dist = max(max_dist, v[i].dist);
		if (v[i].size + size < k) {
			size += v[i].size;
		} else {	
			ans += (max_dist * 2);
			max_dist = v[i].dist;
			int cnt = (v[i].size - k + size) / k;
			size = (v[i].size + size) % k;
			ans += ((max_dist * 2) * cnt);
			if (size > 0) max_dist = max(max_dist, v[i].dist);
			else max_dist = -1e9;					
		}
	}
	if (size > 0) ans += (max_dist * 2);
		
	size = 0, max_dist = -1e9;
	for (int i = 0 ; i < v2.size(); i++) {
		max_dist = max(max_dist, v2[i].dist);
		if (v2[i].size + size < k) {
			size += v2[i].size;
		} else {	
			ans += (max_dist * 2);
			max_dist = v2[i].dist;
			int cnt = (v2[i].size - k + size) / k;
			size = (v2[i].size + size) % k;
			ans += ((max_dist * 2) * cnt);
			if (size > 0) max_dist = max(max_dist, v2[i].dist);
			else max_dist = -1e9;					
		}
	}
	if (size > 0) ans += (max_dist * 2);
	// 
	cout << ans ;

	return 0;
}