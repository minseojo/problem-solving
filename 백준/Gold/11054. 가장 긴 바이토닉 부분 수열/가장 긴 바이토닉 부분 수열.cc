#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int a[1001];
int dp[1001];
int reverse_dp[1001];

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> a[i];
        dp[i] = 1;
        reverse_dp[i] = 1;
    }

    //dp
    for(int i=0; i<n; i++) {
        for(int j=i+1; j<n; j++) {
            if(a[j] > a[i]) {
                dp[j] = max(dp[j], dp[i]+1);
            }
        }
        dp[i] = max(dp[i], dp[i-1]);
    }

    // reverse_dp
    for(int i=n-1; i>=0; i--) {
        for(int j=i-1; j>=0; j--) {
            if(a[j] > a[i]) {
                reverse_dp[j] = max(reverse_dp[j], reverse_dp[i]+1);
            }
        }
        reverse_dp[i] = max(reverse_dp[i], reverse_dp[i+1]);        
    }
    int result = 0;
    for(int i=0; i<n; i++) {
        result = max(result, dp[i]+reverse_dp[i]-1);
    }
    cout << result;
    return 0;
}