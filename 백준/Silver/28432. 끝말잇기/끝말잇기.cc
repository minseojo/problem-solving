#include <bits/stdc++.h>
#include <map>
#include <vector>
using namespace std;

string a[102];
map<string, bool> duple;
string b[102];

int main() {
	int n, m;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		duple.insert({a[i], true});
	}
	
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> b[i];
	}
	
	if (n == 1) {
		cout << b[0];
		return 0;
	}
	
	for (int i = 0; i < n; i++) {
		if (a[i] == "?") {
			if (i == 0) {
				if (i+1 < n) {
					char next = a[i+1][0];
					for (int j = 0; j < m; j++) {
						if (b[j][b[j].length()-1] == next && duple.find(b[j]) == duple.end()) {
							cout << b[j];
							return 0;
						}
					}
				}
			} 
			
			else if (i == n-1) {
				char prev = a[i-1][a[i-1].length()-1];
				
				for (int j = 0; j < m; j++) {
					if (b[j][0] == prev && duple.find(b[j]) == duple.end()) {
						cout << b[j];
						return 0;
					}
				}
			} 

			else {
				
				char prev = a[i-1][a[i-1].length()-1];
				char next = a[i+1][0];
				
				for (int j = 0; j < m; j++) {
					if (duple.find(b[j]) == duple.end() && 
					b[j][b[j].length()-1] == next &&
					b[j][0] == prev) {
						cout << b[j];
						return 0;
					}
				}
			}
		}
	}
	
	return 0;
}