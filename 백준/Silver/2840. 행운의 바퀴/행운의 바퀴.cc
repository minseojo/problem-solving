#include <bits/stdc++.h>
using namespace std;

int check[26]; // 알파벳은 최대 1개

int main() {
    int N, K;
    cin >> N >> K;
    list<char> wheel;
    for (int i = 0; i < N; i++) wheel.push_back('?');
    list<char>::iterator iter = wheel.begin();

    for (int i = 0; i < K; i++) {
        int s;
        char c;
        cin >> s >> c;
        
        while (s--) {
            iter--;
            if (iter == wheel.end()) iter--;
        }

        if (*iter != '?' && *iter != c) {
            cout << "!";
            return 0;
        }
        else if (*iter == '?') {
            if (check[c - 'A'] > 0) {
                cout << "!";
                return 0;
            }
            check[c - 'A']++;
        }
        *iter = c;
    }

    for (int i = 0; i < N; i++) {
        cout << *iter;
        iter++;
        if (iter == wheel.end()) iter = wheel.begin();
    }
    return 0;
}