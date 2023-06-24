#include <bits/stdc++.h>
using namespace std;

int main() {
	string s;
	cin >> s;
	
	int start = 0;
	int range = min(3, (int)s.length());
	
	for (int i = 0; i < range; i++) {
		start = start * 10 + (s[i] - '0');
		string x = "";
		
		for (int j = start; ; j++) {
			x += to_string(j);
			
			if (x == s) {
				cout << start << " " << j;
				return 0;
			}
			
			if (x.size() > s.size()) {
				break;
			}
		}
	}
}