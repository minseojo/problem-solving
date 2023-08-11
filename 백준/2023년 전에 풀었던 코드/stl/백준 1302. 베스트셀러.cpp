#include <bits/stdc++.h>
using namespace std;

map<string, int> sell;

int main() {
	int N;
	cin >> N;
	
	string book;
	for(int i=0; i<N; i++) {
		cin >> book;
		sell[book]++;
	}
	
	int cnt = 0;
	string answer = "";
	for(auto iter : sell) {
		if(iter.second > cnt) {
			cnt = iter.second;
			answer = iter.first;
		}
	}
	
	cout << answer;
}
