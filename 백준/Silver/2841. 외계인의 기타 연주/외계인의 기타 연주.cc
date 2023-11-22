#include <bits/stdc++.h>
using namespace std;

int N, P;
stack<int> melody[7];

int main() {
    cin >> N >> P;

    int ans = 0;
    for (int i = 0; i < N; i++) {
        int n, p;
        cin >> n >> p;
        if (melody[n].empty()) {
            ans++;
            melody[n].push(p);
        }
        else {
            while (!melody[n].empty() && melody[n].top() > p) {
                ans++;
                melody[n].pop();
            }

            if (melody[n].empty() || !melody[n].empty() && melody[n].top() != p) {
                ans++;
                melody[n].push(p);
            }
        }
    }

    cout << ans << "\n";
    return 0;
}