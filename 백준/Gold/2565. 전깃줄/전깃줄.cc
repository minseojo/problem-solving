#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

struct st {
    int value;
    int index;
};

bool cmp(const st& a, const st& b) {
    return a.index < b.index;
}

vector<st> v;
int a[101];
int dp[101];

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
        int value, index;
        cin >> value >> index;
        v.push_back({value, index});
    }
    sort(v.begin(), v.end(), cmp);
    for(int i=0; i<n; i++) {
        a[i] = v.at(i).value;
        dp[i] = 1;
    }

    // lis
    for(int i=0; i<n; i++) {
        for(int j=i+1; j<n; j++) {
            if(a[j] > a[i]) {
                dp[j] = max(dp[j], dp[i] + 1);
            }
        }
        dp[i] = max(dp[i], dp[i-1]);
    }

    int result = n, max_dp = 0;
    for(int i=0; i<n; i++) {
        max_dp = max(max_dp, dp[i]);
    }

    cout << result-max_dp;
    
    return 0;
}