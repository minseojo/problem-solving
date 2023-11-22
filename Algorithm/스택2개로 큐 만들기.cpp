#include <bits/stdc++.h>
using namespace std;

stack<int> s;
stack<int> s2;

int main() {
	int n;
	cin >> n;
	for(int i=0; i<n; i++) {
		int num;
		cin >> num;
		s.push(num);
	}
	while(!s.empty()) {
		s2.push(s.top());
		s.pop();
	}
	
	while(!s2.empty()) {
		cout << s2.top() << " ";
		s2.pop();
	}
}
