#include <bits/stdc++.h>
using namespace std;

const int MAX = 100001;
const int MAX_D = 29; // 2^30 = 약 10.7억, 2^29 = 약 5.3억

int dist[MAX][MAX_D + 1];
int start[MAX];

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);

    int N, K, M;
    cin >> N >> K >> M;
    for (int i = 1; i <= N; i++) {
        cin >> start[i];
    }
    for (int i = 1; i <= K; i++) {
        cin >> dist[i][0];
    }
    for (int j = 1; j <= MAX_D; j++) {
        for (int i = 1; i <= K; i++) {
            dist[i][j] = dist[dist[i][j - 1]][j - 1];
        }
    }

    for (int i = 1; i <= N; i++) {
        int n = M - 1;
        int x = start[i];
        for (int j = MAX_D; j >= 0; j--) {
            if (n >= (1 << j)) {
                n -= (1 << j);
                x = dist[x][j];
            }
        }
        cout << x << " ";
    }
    return 0;
}