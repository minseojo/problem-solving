#include <bits/stdc++.h>
using namespace std;

vector<int> row; // 자른 행 위치
vector<int> column; // 자른 열 위치

int main() {
    int n, m, tc;
    cin >> m >> n >> tc; // n은 row, m은 column

    row.push_back(0);
    row.push_back(n);
    column.push_back(0);
    column.push_back(m);
    while(tc--) {
        int type, pos; // type, position
        cin >> type >> pos;
        if (type == 0) {
            row.push_back(pos);
        } else {
            column.push_back(pos);
        }
    }

    sort(row.begin(), row.end());
    sort(column.begin(), column.end());
    int ans = 0;
    for (int i = 0; i < row.size()-1; i++) {
        for (int j = 0; j < column.size()-1; j++) {
            ans = max(ans, (row[i+1]-row[i]) * (column[j+1]-column[j]));
        }
    }
    cout << ans;
    return 0;
}