#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int n;
int answer = 0;
bool col[15];
bool diag1[30]; //오른쪽 아래 대각선 (0, 0) 기준
bool diag2[30]; //오른쪽 위 대각선 (n-1, 0) 기준

void NQueen(int y) {
    if(y == n) {
        answer++;
        return;
    }

    for(int x=0; x<n; x++) {
        if(col[x] || diag1[x-y+n-1] || diag2[x+y]) continue;
        col[x] = diag1[x-y+n-1] = diag2[x+y] = true;
        NQueen(y+1);
        col[x] = diag1[x-y+n-1] = diag2[x+y] = false;
    }
}

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    cin >> n;
    NQueen(0);
    cout << answer;
    return 0;
}