#include <iostream>
#include <queue>
#include <vector>
#include <string.h>

using namespace std;

struct Point {
    int cur;
    int cost;
};

struct comp {
    bool operator()(Point &a, Point &b) {
        return a.cost > b.cost;
    }
};
priority_queue<Point, vector<Point>, comp> pq;

int cache[100001];
const int MAX = 100001;

int dijkstra(int n, int k) {
    for (int i = 0; i < MAX; i++) {
        cache[i] = MAX;
    }
    
    pq.push({n, 0});
    cache[n] = 0;
    while(!pq.empty()) {
        int cur = pq.top().cur;
        int cost = pq.top().cost;
        pq.pop();

        if (cache[cur] < cost) continue;

        if (0 < cur) {
            if (cache[cur-1] > cost + 1) {
                cache[cur-1] = cost + 1;
                pq.push({cur-1, cost+1});
            }
        }
        if (0 <= cur && cur+1 < MAX) {
            if (cache[cur+1] > cost + 1) {
                cache[cur+1] = cost + 1;
                pq.push({cur+1, cost+1});
            }
        }
        if (0 <= cur && cur*2 < MAX) {
            if (cache[cur*2] > cost) {
                cache[cur*2] = cost;
                pq.push({cur*2, cost});
            }
        }
    }

    return 0;
}

int main() {
    int n, k;
    cin >> n >> k;
    if (n == k) cout << 0;
    else {
        dijkstra(n, k);
        cout << cache[k];
    }

    return 0;
}