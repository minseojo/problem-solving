#include <bits/stdc++.h>
using namespace std;

int alpha[26];
char answer[50];

void solve(int odd_cnt, int size) {
	if(odd_cnt > 1) {
		cout << "I'm Sorry Hansoo";
		return;
	} else {
		int l=0, r=size-1;
		for(int i=0; i<26; i++) {
			while(alpha[i] > 1) {
				answer[l++] = i + 'A';
				answer[r--] = i + 'A';
				alpha[i] -= 2;
			}
		}
		
		for(int i=0; i<size; i++) {
			cout << answer[i];
		}
	}
}

int main() {
	string s;
	cin >> s;
	int size = s.size();
	for(int i=0; i<size; i++) {
		alpha[s[i]-'A']++;
	}
	
	int odd_cnt = 0;
	for(int i=0; i<26; i++) {
		if(alpha[i]%2 == 1) {
			odd_cnt++;
			answer[size/2] = i + 'A';
		}
	}
	
	solve(odd_cnt, size); 
	return 0;
}