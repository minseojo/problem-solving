#include <bits/stdc++.h>
using namespace std;

string n;
int check[51];
int max_num;
vector<string> ans;

bool finish = false;
void dfs(string s) {
    if (finish) return;
    if (s.size() == n.size()) {
        finish = true;
        return;
    }

    for (int i = 1; i <= 2; i++) {
        string x = n.substr(s.size(), i);
        int num = stoi(x);
        if (num == 0) return;
        if (num > max_num || check[num]) continue;
        check[num] = true;
        ans.push_back(x);
        dfs(s + x);
        if (finish) return;
        ans.pop_back();
        check[num] = false;
    }
}

int main() {
    cin >> n;
    if (n.size() < 10) max_num = 9;
    else max_num = 9 + (n.size()-9) / 2;
    dfs("");
    for (string a : ans) {
        cout << a << " ";
    }
    return 0;
}