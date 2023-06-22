//
//  22353.cpp
//  cpp
//
//  Created by 조민서 on 2023/06/22.
//

#include <bits/stdc++.h>
using namespace std;

int main() {
    const string UCPC = "UCPC";
    int pos = 0;
    string str;
    getline(cin, str);
    for (int i = 0; i < str.length(); i++) {
        char c = str[i];
        if (c == UCPC[pos]) {
            pos++;
        }
    }
    
    if (pos == UCPC.length()) {
        cout << "I love UCPC";
    } else {
        cout << "I hate UCPC";
    }
    
    return 0;
}