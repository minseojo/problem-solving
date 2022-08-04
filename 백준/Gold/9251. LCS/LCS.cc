#include <bits/stdc++.h>
using namespace std;

string a, b;
int dp[1001];

void solve() {
    int cnt = 0;
    for(int i=0; i<a.length(); i++) {
        cnt = 0;
        for(int j=0; j<b.length(); j++) {
            if(cnt < dp[j]) cnt = dp[j];
            else if(a[i] == b[j]) {
                dp[j] = cnt+1;
            }
        }
    }
}

int getAnswer() {
    int answer = 0;
    for(int i=0; i<b.length(); i++) {
        if(answer < dp[i]) answer = dp[i];
    }
    
    return answer;
}

int main() {
	cin >> a >> b;
    
    solve();
    cout << getAnswer();
    
    return 0;
}