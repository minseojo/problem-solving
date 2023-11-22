#include <bits/stdc++.h>
using namespace std;

int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        string str = "";
        cin >> str;

        list<char> password;
        list<char>::iterator iter = password.begin();
        for (int i = 0; i < str.size(); i++) {
            char c = str[i];
            if (c == '<') {
                if (iter != password.begin()) iter--;
            } 
            else if (c == '>') {
                if (iter != password.end()) iter++;
            } 
            else if (c == '-') {
                if (iter != password.begin()) {
                    iter--;
                    iter = password.erase(iter);
                }
            } 
            else {
                password.insert(iter, c);
            }
        }
        iter = password.begin();
        while (iter != password.end()) {
            cout << *iter;
            iter++;
        }
        cout << "\n";
    }
    return 0;
}