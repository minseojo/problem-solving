#include <bits/stdc++.h>
using namespace std;

stack<char> s;

int main() {
	string str;
	cin >> str;
	
	int answer=0;
	for(int i=0; i<str.size(); i++) {
		if(str[i]=='(') {
			s.push('(');
		} else {
			s.pop(); 
			if(str[i-1]=='(') {
				answer+=s.size();	
			} else {
				answer++;
			}
		}
	}
	
	cout << answer;
	return 0;
}
