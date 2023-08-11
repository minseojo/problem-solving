#include <bits/stdc++.h>
using namespace std;

vector<string> v;
vector<string> ret;

int main() {
	int n, m;
	string str;
	cin >> n >> m;
	v.resize(n);
	for(int i=0; i<n; i++) {
		cin >> v[i];
	}
	sort(v.begin(), v.end());
	for(int i=0; i<m; i++) {
		cin >> str;
		if(binary_search(v.begin(), v.end(), str)) {
			ret.push_back(str);
		}
	}
	sort(ret.begin(), ret.end());
	cout << ret.size() << endl;
	for(int i= 0; i<ret.size(); i++) {
		cout << ret.at(i) << endl;
	}
}
