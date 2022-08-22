#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

int main() {	
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    
	int tc, n, m;
	cin >> tc;
	while(tc--) {
		cin >> n;
		unordered_map<int, int> Map;
		
		int x;
		for (int i=0; i<n; i++) {
			cin >> x;
			Map[x] = 1;
		}
		
		cin >> m;
		for (int j=0; j<m; j++) {
			cin >> x;
			if (Map[x] == 1) {
				cout << 1 << endl;
			}
			else {
				cout << 0 << endl;
			}
		}
	}
	
	return 0;
}