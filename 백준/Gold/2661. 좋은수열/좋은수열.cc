#include <bits/stdc++.h>
using namespace std;

int n;
bool check(string s) {
    int len = s.size();
    for (int i = 1; i <= len/2; i++) {
        if (s.substr(len-2*i, i) == s.substr(len-i, i)) return false;
    }
    return true;
}

bool finish = false;
void dfs(string s) {
    if (finish) return;

    if (s.size() == n) {
        cout << s;
        finish = true;
        return;
    }

    for (int i = 1; i <= 3; i++) {
        if (check(s + to_string(i))) dfs(s + to_string(i));
    }
}

int main() {
    cin >> n;
    dfs(""); 
    return 0;
}