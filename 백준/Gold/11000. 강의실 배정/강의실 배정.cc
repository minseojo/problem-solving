#include <bits/stdc++.h>
using namespace std;

struct Class {
    int s;
    int t;
};
vector<Class> v;
bool comp(const Class&  a, const Class& b) {
    if (a.s == b.s) return a.t < b.t;
    return a.s < b.s;
}

priority_queue<int, vector<int>, greater<int>> pq;

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int s, t;
        cin >> s >> t;
        v.push_back({s, t});
    }
    sort(v.begin(), v.end(), comp);
    int ans = 0;
    for (int i = 0; i < n; i++) {
        if (pq.empty()) pq.push(v[i].t);
        else {
            int prev_t = pq.top();
            int cur_s = v[i].s;
            if (prev_t > cur_s) {
                pq.push(v[i].t);
            } else {
                pq.pop();
                pq.push(v[i].t);
            }
        }
        int size = pq.size();
        ans = max(ans, size);
    }
    cout << ans;
    return 0;
}