#include <iostream>
#include <set>
#include <string.h>
using namespace std;

bool isPass[11];
int check[11];
int ans = 0;
void dfs(int pos, int n, int m, string str) {
    if (pos == n) {
        int cnt = 0;
        memset(check, 0, sizeof(check));
        for (int i = 0; i < n; i++) {
            check[str[i]-'0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (isPass[i] && check[i] > 0) cnt++;
        }
        if (cnt == m) { 
            ans++;
        }
        return;
    }

    for (int i = 0; i < 10; i++) {
        str[pos] = (i+'0');
        dfs(pos+1, n, m, str);
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int num;
        cin >> num;
        isPass[num] = true;
    }
    string x = "xxxxxxxxxx";
    dfs(0, n, m, x);
    cout << ans;
}