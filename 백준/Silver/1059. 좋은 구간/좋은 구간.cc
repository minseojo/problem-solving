#include <bits/stdc++.h>
using namespace std;

int l, n;
vector<int> s;

int solution() {
	int answer = 0;
	
	sort(s.begin(), s.end());
	if(s[0] > n) {
		return answer = n * (s[0]-n) - 1;
	}
	
	for(int i=0; i<s.size(); i++) {	
		if(s[i] < n && n < s[i+1]) {
			answer = (n-s[i]) * (s[i+1]-n) -1;
		}
	}
	return answer;
}

int main() {
	cin >> l;
	int number;
	for(int i=0; i<l; i++) {
		cin >> number;
		s.push_back(number);
	}
	cin >> n;
	
	cout << solution();
}