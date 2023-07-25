#include <bits/stdc++.h>
using namespace std;
string message[8] = {"000000", "001111", "010011", "011100", 
				"100110", "101001", "110101", "111010"};
const int SIZE = 6;
string ans;

int main() {
	int n;
	string s;
	cin >> n >> s;
	
	
	int pos = 0, first_dif = 1e9;
	string  str = "";

	for (int i = 0; i < s.size(); i++) {
		if (pos == SIZE) {
			int dif = 0;
			bool find = false;
			
			for (int j = 0; j < 8; j++) {
				dif = 0;
				for (int k = 0; k < message[j].size(); k++) {
					if (message[j][k] != str[k]) {
						dif++;
					}
				}
				if (dif < 2) {
					ans += (char) ('A'+j);
					find = true;
				}
				
				if(find) break;
			}
			if (!find) {
				first_dif = min(first_dif, (i/6));
			}
			pos = 0; 
			str = "";
		}
		str += s[i];
		pos++;
	}
	
	int dif = 0;
	bool find = false;
	for (int j = 0; j < 8; j++) {
		dif = 0;
		find = false;
		for (int k = 0; k < message[j].size(); k++) {
			if (message[j][k] != str[k]) {
				dif++;
			}
		}
		if (dif < 2) {
			ans += (char) ('A'+j);
			find = true;
		}
		if(find) break;
	}
	if (!find) {
		int size = s.size();
		first_dif = min(first_dif, (size/6));
	}	
	
	if (ans.size() == n && first_dif == 1e9) {
		cout << ans;
	} else {
		cout << first_dif;
	}

	return 0;
}