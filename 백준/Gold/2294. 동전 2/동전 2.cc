#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int n, k;
vector<int> coins;
int dp[100001];
const int MAX = 1e6;

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    cin >> n >> k;
    coins.push_back(-1);
    for(int i=0; i<n; i++) {
        int c;
        cin >> c;
        coins.push_back(c);
    }
    for(int i=1; i<=k; i++) dp[i] = MAX;

    for(int i=1; i<coins.size(); i++) {
        int c = coins.at(i);
        for(int j=1; j<=k; j++) {
            if(j-c >= 0) {
                dp[j] = min(dp[j], dp[j-c]+1);
            } 
        }
    }
    if(dp[k] == MAX) cout << -1;
    else cout << dp[k];
 
    return 0;
}