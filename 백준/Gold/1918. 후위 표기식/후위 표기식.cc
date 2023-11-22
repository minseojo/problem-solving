#include <bits/stdc++.h>
using namespace std;

int main() {
	string s, ans = "";
	cin >> s;
	stack<char> ex;
	
	for (int i = 0; i < s.size(); i++) {
		if ('A' <= s[i] && s[i] <= 'Z') {
			ans += s[i];	
		}
		else if (s[i] == '(') {
			ex.push('(');
		}
		else if(s[i] == ')') {
			while(!ex.empty() && ex.top() != '(') {
				ans += ex.top();
				ex.pop();
			}
			ex.pop();
		}
		else if (s[i] == '*' || s[i] == '/') {
			if (!ex.empty() && (ex.top() == '*' || ex.top() == '/')) {
				ans += ex.top();
				ex.pop();
			}
			ex.push(s[i]);
		} 
		else if (s[i] == '+' || s[i] == '-') {
			while (!ex.empty() && ex.top() != '(') {
				ans += ex.top();
				ex.pop();
			}
			ex.push(s[i]);
		}
	}
	while(!ex.empty()) {
		ans += ex.top();
		ex.pop();
	}
	
 	cout << ans;
	return 0;
}
