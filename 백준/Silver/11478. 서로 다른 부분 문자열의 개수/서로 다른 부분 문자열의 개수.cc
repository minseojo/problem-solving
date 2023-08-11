#include <iostream>
#include <vector>
#include <set>
#include <bits/stdc++.h>
using namespace std;

set<string> result;
string str;

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    cin >> str;
    for(int i=0; i<str.size(); i++) {
        string temp = ""; 
        for(int j=i; j<str.size(); j++) {
            temp += str[j];
            result.insert(temp);
        }
    }
    cout << result.size();
    return 0;
}