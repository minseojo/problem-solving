#include <bits/stdc++.h>
using namespace std;

int N, K, C;
vector<pair<int, int> > v;
multiset<int> k;
long long answer = 0;

// 가격순으로 정렬, 가장비싼거부터 넣을 수 있으면 넣기 
int main() {
	cin >> N >> K;
	for(int i=0; i<N; i++) {
		int M, V;
		cin >> M >> V;
		v.push_back({V, M});
	}
	for(int i=0; i<K; i++) {
		cin >> C;
		k.insert(C);
	}
	sort(v.begin(), v.end());
	reverse(v.begin(), v.end());
	// 가격, 질량 
	for(auto &p : v) {
		if(k.size()==0) break;
		auto iter = k.lower_bound(p.second);
		if(iter != k.end()) {
			answer+=p.first;
			k.erase(iter);
		}
	}
	cout << answer;
	return 0;
}