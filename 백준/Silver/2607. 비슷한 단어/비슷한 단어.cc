#include <bits/stdc++.h>
using namespace std;

int alpha_copy[26];
string first;

bool compareAlpha(string second) {
	int fs = first.length();
	int ss = second.length();
	if(abs(fs-ss) > 1) return false;
	
	int alpha[26];
	int dupl_and_dif = 0;

	for(int i=0; i<26; i++) {
		alpha[i] = alpha_copy[i];
	}
	for(int i=0; i<second.length(); i++) {
		int idx = second[i]-'A';
		if(alpha[idx] > 0) {
			alpha[idx]--;
		} else if(alpha[idx] == 0) {
			dupl_and_dif++;
		}
		if(dupl_and_dif > 1) return false;
	}
	if(fs-ss == 1 && dupl_and_dif == 1) return false;
	return true;
}
int main() {
	int n;
	cin >> n;
	if(n > 0) cin >> first;
	for(int i=0; i<first.length(); i++) {
		alpha_copy[first[i]-'A']++;
	}

	int answer=0;
	for(int i=0; i<n-1; i++) {
		string second;
		cin >> second;

		if(compareAlpha(second)) {
			answer++;
		}
	}
	cout << answer;
}