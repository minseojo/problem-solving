#include <iostream>
#include <vector>
#include <set>
#include <bits/stdc++.h>
#define int long long
using namespace std;

int n, m;
int sum[1000000];
int sum_count[1000000];
signed main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    cin >> n >> m;
    int num, result=0;
    for(int i=0; i<n; i++) {
        cin >> num;
        if(i==0) sum[i] = num;
        else sum[i] += (sum[i-1]+num);

        sum_count[sum[i]%m]++;

        if(sum[i]%m == 0) result++;
    }
    for(int i=0; i<m; i++) {
        int x = sum_count[i];
        result += (x*(x-1))/2;
    }
    cout << result;
    return 0;
}