#include <bits/stdc++.h>
#define MAX 15
using namespace std;

int n;
bool col[MAX];
bool visited1[2 * MAX]; //오른쪽 아래 대각선 (0, 0) 기준
bool visited2[2 * MAX]; //오른쪽 위 대각선 (n-1, 0) 기준
int ans;

void NQueen(int y) {
    if(y == n) {
        ans++;
        return;
    }

    for(int x=0; x<n; x++) {
        if(col[x] || visited1[x - y + n] || visited2[x + y + 1]) continue;
        col[x] = visited1[x - y + n] = visited2[x + y + 1] = true;
        NQueen(y + 1);
        col[x] = visited1[x - y + n] = visited2[x + y + 1] = false;
    }
}

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    cin >> n;
    NQueen(0);
    cout << ans;
    return 0;
}