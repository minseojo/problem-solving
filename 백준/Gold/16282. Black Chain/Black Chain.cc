#include <bits/stdc++.h>
using namespace std;

int main() {
    long long n, x = 0, ans = 0;
    cin >> n;

    /*
    a = i+1
    r = 2
    l = 2^(i+1)
    (i+1)*(2^(i+1) - 1)/(2-1) = (i+1) * (2^(i+1) - 1) = (i+1) * 2^(i+1) - i - 1    + i(1의 개수)
    따라서 (i+1) * 2^(i+1) - i 
    */
    for (int i = 1; x < n; i++) { 
        x = (i + 1)* (long long) pow(2, i + 1) - 1;
        ans++;
    }
    cout << ans;
    return 0;
}