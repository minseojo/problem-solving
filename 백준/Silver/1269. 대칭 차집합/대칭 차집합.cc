#include <iostream>
#include <vector>
#include <map>
#include <bits/stdc++.h>
using namespace std;

map<int, bool> a;
map<int, bool> b;
map<int, bool>::iterator it;
int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    int ac, bc, num;
    cin >> ac >> bc;
    for(int i=0; i<ac; i++) {
        cin >> num;
        a.insert(make_pair(num, true));
    }
    for(int i=0; i<bc; i++) {
        cin >> num;
        it = a.find(num);
        if(it != a.end()) {
            a.erase(num);
        } else {
            b.insert(make_pair(num, true));
        }
    }
    cout << a.size() + b.size();
    return 0;
}