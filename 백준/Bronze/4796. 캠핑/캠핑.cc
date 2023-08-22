#include <bits/stdc++.h>
using namespace std;

int main() {
    int tc = 1;
    while(1) {
        int l, p, v;
        cin >> l >> p >> v;
        if (l == 0 && p == 0 && v == 0) break;
        int ans = (v/p)*l + min(v%p, l);
        cout << "Case " << tc << ": " << ans << endl;
        tc++;
    }

    return 0;
}