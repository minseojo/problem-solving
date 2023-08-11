#include <bits/stdc++.h>
using namespace std;

bool compare1(pair<int, pair<int, int > > a, pair<int, pair<int, int > > b) {
	return a.first < b.first;
}

bool compare2(pair<int, pair<int, int > > a, pair<int, pair<int, int > > b) {
	return a.second.first < b.second.first;
}

int main() {
	int n;
	cin >> n;
	vector<pair< int, pair<int ,int > > > v(n);
	
	for(int i=0; i<n; i++) 
		cin >> v[i].first;
	
	for(int i=0; i<n; i++) 
		v[i].second.first=i;
		
	sort(v.begin(), v.end(), compare1);
	
	int cnt=0;
	for(int i=0; i<n; i++) {
		v[i].second.second=cnt;
		if(v[i].first!=v[i+1].first) cnt++;
	}
	
	sort(v.begin(), v.end(), compare2);
	
	for(int i=0; i<n; i++) {
		cout << v[i].second.second <<  " ";
	}	
}
