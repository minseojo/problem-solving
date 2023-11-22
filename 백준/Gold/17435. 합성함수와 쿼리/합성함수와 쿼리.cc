#include <bits/stdc++.h>
using namespace std;

const int MAX = 500001;
const int MAX_D = 18; // 2^18 = 약 26만, 2^19 = 약 52만

int dist[MAX][MAX_D + 1]; // 0 ~ 18

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    
    int m;
    cin >> m;
    for (int i = 1; i <= m; i++) {
        cin >> dist[i][0];
    }
    for (int j = 1; j <= MAX_D; j++) {
        for (int i = 1; i <= m; i++) {
            dist[i][j] = dist[dist[i][j - 1]][j - 1];
        }
    }

    int Q;
    cin >> Q;
    for (int i = 0; i < Q; i++) {
        int n, x;
        cin >> n >> x;
        for (int j = MAX_D; j >= 0; j--) {
            if (n >= (1 << j)) {
                n -= (1 << j);
                x = dist[x][j];
            }
        }
        cout << x << "\n";
    }
    return 0;
}