#include <bits/stdc++.h>
using namespace std;

int main() {
	int tc, n, m;
	cin >> tc;
	
	while(tc--) {
		int ret=0;
		cin >> n >> m;
		for(int i=n; i<=m; i++) {
			string str=to_string(i);
			for(int j=0; j<str.size(); j++) {
				if(j[j]=='0') ret++;
			}
		}
		cout << ret << endl;
	}
	
}
