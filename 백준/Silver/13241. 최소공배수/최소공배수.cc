#include <iostream>
#include <vector>
#include <bits/stdc++.h>
#define int long long
using namespace std;
int n, m;

int gcd(int n, int m) {
    if(m == 0) return n;
    else return gcd(m, n%m);
}

signed main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    cin >> n >> m;    
    cout << (n*m)/gcd(n, m);
    return 0;
}