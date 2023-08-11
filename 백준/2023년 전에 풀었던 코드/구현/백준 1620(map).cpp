#include <bits/stdc++.h>
using namespace std;

map<string, int> List;
vector<string> v;
map<int, string> answer;

int main() {
    
    ios_base::sync_with_stdio(false);	
    cin.tie(NULL);
    cout.tie(NULL);
    
	int m, n;
	cin >> m >> n;
	for(int i=0; i<m; i++) {
		string str;
		cin >> str;
		v.push_back(str);		
		List[str]=i+1;
	}
	
	for(int i=0; i<n; i++) {
		string str;
		cin >> str;
		if(isdigit(str[0])!=0) {
			int x = stoi(str);
			cout << v.at(x-1) << "\n";
		} else {
			cout << List[str] << "\n";
		}
	}
		
	return 0;
}
