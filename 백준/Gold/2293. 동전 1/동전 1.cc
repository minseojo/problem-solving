#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int n, k;
vector<int> coins;
int dp[100001];

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    cin >> n >> k;
    for(int i=0; i<n; i++) {
        int c;
        cin >> c;
        coins.push_back(c);
    }

    dp[0] = 1;
    for(int i=0; i<coins.size(); i++) {
        int c = coins.at(i);
        for(int j=c; j<=k; j++) {
            dp[j] += dp[j-c];
        }
    }
    
    cout << dp[k];
    return 0;
}