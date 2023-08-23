#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;

    int ans = 0;
    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        if (str.size() % 2 == 1) continue;
        
        stack<char> s;
        for (int j = 0; j < str.size(); j++) {
            if (s.empty()) {
                s.push(str[j]);
            } else {
                if (s.top() != str[j]) s.push(str[j]);
                else s.pop();
            }
        }
        if (s.empty()) ans++;
    }
    cout << ans << endl;
    return 0;
}