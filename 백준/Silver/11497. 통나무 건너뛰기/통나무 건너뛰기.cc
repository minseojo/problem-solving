#include <bits/stdc++.h>
using namespace std;

int a[10001];

int main() {
	// input
	int tc;
    cin >> tc;
    while(tc--) {
        int n;
        cin >> n;
        memset(a, 0, sizeof(a));
        vector<int> v;
        for(int i=1; i<=n; i++) cin >> a[i];
        // solve
        sort(a+1, a+n+1);
        int s=-1;
        if(n%2==0)  s=n;
        else s=n-1;
        for(int i=1; i<=n; i+=2) v.push_back(a[i]);
        for(int i=s; i>=2; i-=2) v.push_back(a[i]);
        int answer = 0;
        for(int i=0; i<v.size()-1; i++) {
            answer = max(answer, abs(v.at(i)-v.at(i+1)));
        }         
        answer = max(answer, abs(v.at(0)-v.at(n-1)));
	    cout << answer << endl;
     }
	
	
	return 0;
}