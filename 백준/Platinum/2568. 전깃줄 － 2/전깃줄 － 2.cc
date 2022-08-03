#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

struct st {
	int from;
	int to;
};
vector<st> v;

int n;
int dp[100001];
vector<int> lis;
int answer[500001];

bool comp(st& a, st& b) {
	return a.from < b.from;
}

void solve() {
	int size = 0, cur = -1;
	
	for(int i=0; i<n; i++) {
		int num = v[i].to;		
		if(i == 0) {
			lis.push_back(num);
			dp[i] = 1;
		} else {
			if(lis.back() < num) {
				lis.push_back(num);
				dp[i] = lis.size();
			} else {
				auto iter = lower_bound(lis.begin(), lis.end(), num);
				*(iter) = num;
				dp[i] = iter-lis.begin()+1;
			}
		}
		
		if(dp[i] > size) {
			size = dp[i];
			cur = i;
		}
	}
	
	cout << n-size << endl;
	vector<int> result;
	result.push_back(v[cur].from);
	int pre = cur;
	// 		1 2 3 4
	// 		1 3 1 2
	//dp	1 2 1 2

	for(int i=cur-1; i>=0; i--) {
		if(dp[i]+1 == dp[pre] && v[i].to < v[pre].to) {
			result.push_back(v[i].from);
			pre = i;
		}
	}
	/*
	4
1 1
2 3
3 1
4 2
	*/
	sort(result.begin(), result.end());
	for(int i=0; i<n; i++) {
		answer[v[i].from] = 1;
	}
	
	for(int i=0; i<result.size(); i++) {
		answer[result[i]] = 0;
	}
	
	for(int i=1; i<500001; i++) {
		if(answer[i] == 1) cout << i << endl;
	}

	return;
}

int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
    
	cin >> n;
	int a, b;
	for(int i=0; i<n; i++) {
		cin >> a >> b;
		v.push_back({a, b});
	}
	
	sort(v.begin(), v.end(), comp);
	solve();
	
	return 0;
}