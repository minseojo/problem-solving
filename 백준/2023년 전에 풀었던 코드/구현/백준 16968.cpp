#include <bits/stdc++.h>
using namespace std;

int main() {
	string s;
	cin >> s;
	int dCnt=0, cCnt=0;
	long long answer=1;
	for(int i=0; i<s.length(); i++) {
		if(s[i]=='d') {
			answer*=(10-dCnt);
			dCnt=0;
		} else {
			answer*=(26-cCnt);
			cCnt=0;
		}
		if(s[i]==s[i+1] && s[i]=='d') dCnt++;
		else if(s[i]==s[i+1] && s[i]=='c') cCnt++;
	}
	
	cout << answer;
	
	return 0;
} 
