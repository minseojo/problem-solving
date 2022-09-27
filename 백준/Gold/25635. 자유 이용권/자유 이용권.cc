#include <bits/stdc++.h>
using namespace std;

int n;
int ticket[100001];

int main() {
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> ticket[i];
    }
    
    sort(ticket, ticket+n);
    long long answer = 0;
    for(int i=0; i<n-1; i++) {
        answer += ticket[i];
    }
    if(answer < ticket[n-1]) answer += answer+1;
    else answer += ticket[n-1];
    cout << answer;
    return 0;
}