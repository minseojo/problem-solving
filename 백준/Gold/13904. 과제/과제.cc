#include <bits/stdc++.h>
using namespace std;

struct Problem {
    int d;
    int w;
};
vector<Problem> v;
bool comp(const Problem& a, const Problem& b) {
    return a.w > b.w;
}
bool check[1001];
int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int d, w;
        cin >> d >> w;
        v.push_back({d, w});
    }
    sort(v.begin(),  v.end(), comp);
    int ans = 0;
    for (int i = 0; i < n; i++) {
        int d = v[i].d;
        for (int j = d; j >= 1; j--) {
            if (!check[j]) {
                check[j] = true;
                ans += v[i].w;
                break;
            }
        }
    }
    cout << ans;
    return 0;
}