#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

struct St {
    int w;
    int v;
};

int n, k;
vector<St> bag;
int dp[100001];

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    cin >> n >> k;
    bag.push_back({-1, -1});
    for(int i=0; i<n; i++) {
        int w, v;
        cin >> w >> v;
        bag.push_back({w, v});
    }

    for(int i=1; i<bag.size(); i++) {
        int w = bag[i].w;
        int v = bag[i].v;
        for(int j=k; j>=0; j--) {
            if(j-w >= 0) {
                dp[j] = max(dp[j], dp[j-w] + v);
            }
        }
    }

    int answer = 0;
    for(int i=1; i<=k; i++) {
        answer = max(answer, dp[i]);
    }
    cout << answer;
    return 0;
}