#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int sum[100001];

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    int n, k;
    cin >> n >> k;
    for(int i=1; i<=n; i++) {
        int num;
        cin >> num;
        sum[i] += sum[i-1] + num;
    }
    int result = -100 * 100000;
    int l=0, r=k;
    while(r <= n) {
        result = max(result, sum[r++]-sum[l++]);
    }
    cout << result;
    return 0;
}