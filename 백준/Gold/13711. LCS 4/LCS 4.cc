#include <bits/stdc++.h>
using namespace std;
int n;
int a[1000001];
int b[1000001];
vector<int> v;
vector<int> lcs;

int solve() {
    for(int i=0; i<n; i++) {
        int x = v[i];
		if(i==0) {
			lcs.push_back(x);
			continue;
		}
		if(lcs.back()>=x) {
			auto iter = lower_bound(lcs.begin(), lcs.end(), x);
			*iter=x;
		} else {
			lcs.push_back(x);
		}
	}
    return lcs.size();
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cin >> n;
    int num;
    for(int i=1; i<=n; i++) {
        cin >> num;
        a[num] = i;
    }
    for(int i=1; i<=n; i++) {
        cin >> b[i];
    }
    for(int i=1; i<=n; i++) v.push_back(a[b[i]]);
    cout<<solve();
}