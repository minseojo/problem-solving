#include <iostream>
#include <vector>
#include <bits/stdc++.h>
#include <stack>
#include <queue>
using namespace std;

vector<char> v;

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    string str, goal;

    cin >> str >> goal;

    int cur = 0;
    for(int i=0; i<str.size(); i++) {
        v.push_back(str[i]);

        if(v.size() >= goal.size()) {
            int cur = 0;
            for(int j=0; j<goal.size(); j++) {
                if(v.at(v.size()-goal.size()+j) == goal[cur]) {
                    cur++;
                } 
                else break;
            }

            if(cur == goal.size()) {
                for(int j=0; j<goal.size(); j++) {
                    v.pop_back();
                }
            }
        }
    }

    if(!v.empty()) {
        for(char i : v) {
            cout << i;
        }
    } else {
        cout << "FRULA";
    }
}