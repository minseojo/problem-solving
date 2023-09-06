#include <bits/stdc++.h>
using namespace std;

const int MAX_WEIGHT = 400000;

int a[5005];
bool cache[MAX_WEIGHT + 1];

int main() {
    int w, n;
    cin >> w >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a + n);
    for (int i = 0; i < n - 2; i++) {
        for (int j = 0; j < i; j++) {
            cache[a[i] + a[j]] = true;
        }

        for (int j = i + 2; j < n; j++) {
            int x = w - a[i + 1] - a[j];
            if (x < 0 || x > MAX_WEIGHT) break;
            if (cache[x]) {
                cout << "YES\n";
                return 0;
            }
        }
    }
    cout << "NO\n";
    return 0;
}