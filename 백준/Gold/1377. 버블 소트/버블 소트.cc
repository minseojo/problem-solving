#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

struct st {
    int value;
    int index;
};

bool cmp (const st& a, const st& b) {
    if(a.value != b.value) return a.value < b.value;
    else return a.index < b.index;
}

vector<st> v;

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
        int num;
        cin >> num;
        v.push_back({num, i});
    }
    sort(v.begin(), v.end(), cmp);
    int result = -1;

    for(int i=0; i<n; i++) {
        if(result < v.at(i).index-i) {
            result = v.at(i).index-i;
        }
    }
    cout << result+1;
    
}