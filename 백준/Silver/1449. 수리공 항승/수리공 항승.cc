#include <bits/stdc++.h>
using namespace std;

vector<float> v;

int main() {
    int n, l;
    cin >> n >> l;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    int ans = 1, pos = v[0]-0.5 + l;
    for (int i = 1; i < n; i++) {
        if (pos < v[i]) {
            ans++;
            pos = v[i]-0.5 + l;
        }
    }
    cout << ans;
    return 0;
}