#include <iostream>
#include <vector>
#include <bits/stdc++.h>
#include <stack>
#include <queue>
using namespace std;

vector<int> v;

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    int n, c;
    cin >> n >> c;
    
    for(int i=0; i<n; i++) {
        int num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());


    c-=2; // 맨 앞, 맨 뒤는 제외하고 시작
    if(c==0) {
        cout << v.at(v.size()-1)-v.at(0);
        return 0;
    }

    int l=1, r=v.at(v.size()-1);
    int result = 0;
    while(l <= r) {
        int m = l + (r-l)/2;
        int count = c;
        int l_index=v.at(0);
        bool ok = false;
        for(int i=1; i<v.size()-1; i++) {
            if(v.at(i)-l_index>=m && v.at(v.size()-1)-v.at(i)>=m) {
                l_index = v.at(i);
                count--;
            }
            if(count == 0) {
                ok = true;
                break;
            }
        }
        //cout << l <<" " << r <<" " << m << endl;
        if(ok) {
            result = max(result, m);
            l = m+1;
        } else {
            r = m-1;
        } 
    }

    cout << result;

}