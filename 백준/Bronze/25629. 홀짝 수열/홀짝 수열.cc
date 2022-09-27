#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin>>n;
    int number, cntE=0, cntO=0;
    for(int i=0; i<n; i++) {
        cin >> number;
        if(number%2==0) cntE++;
        else cntO++;
    }
    if(cntE==cntO || cntE+1==cntO) cout<<1;
    else cout<<0;
    return 0;
}