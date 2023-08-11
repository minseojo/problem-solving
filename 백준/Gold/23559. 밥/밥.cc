#include <iostream>
#include <vector>
#include <queue>
#include <bits/stdc++.h>
using namespace std;

struct st {
    int dif;
    int a;
    int b;
};

struct cmp {
    bool operator()(const st& a, const st& b) {
        if(a.dif == b.dif) {
            if(a.a != b.a) {
                return a.a < b.a;
            } else {
                return a.b < b.b;
            }
        } else {
            return a.dif < b.dif;
        }
    }
};

priority_queue<st, vector<st>, cmp> pq;


int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    int n, x;
    cin >> n >> x;
    for(int i=0; i<n; i++) {
        int a, b;
        cin >> a >> b;
        pq.push({a-b, a, b});
    }
    /**
     * 2 5000
        20 15
        20 15
    */
    int result = 0;
    int d_day = n;
    while(!pq.empty()) {
        d_day -= 1;
        if(pq.top().dif <= 0) {
            result += pq.top().b;
            x -= 1000;
        }
        else if(pq.top().a > pq.top().b && x-5000 >= d_day*1000) {
            result += pq.top().a;
            x -= 5000;
        } else {
            result += pq.top().b;
            x -= 1000;
        }
        pq.pop();
    }
    cout << result;
    return 0;
}