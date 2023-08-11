#include <bits/stdc++.h>
using namespace std;

set<string, greater<string>> company;

int main() {
	ios_base::sync_with_stdio(false);
	
	int n;
	cin >> n;
	
	string name = "", log = ""; 
	for(int i=0; i<n; i++) {
		cin >> name >> log;
		if(log == "enter") {
			if(company.find(name) != company.end()) {
				company.erase(name);
				company.insert(name);
			} else {
				company.insert(name);
			}
		} 
		
		else if(log == "leave") {
			company.erase(name);
		}
	}
	
	for(auto iter : company) {
		cout << iter << "\n";
	}
} 
