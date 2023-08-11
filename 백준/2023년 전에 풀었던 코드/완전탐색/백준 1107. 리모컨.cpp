#include <bits/stdc++.h>
using namespace std;

int N, M, answer;
vector<int> button;
bool Lock[10];

bool check(int num) {
	string s = to_string(num);
	for(int i=0; i<s.size(); i++) {
		if(Lock[s[i]-'0'])
			return false;	
	}
	
	return true;
}

int main() {
	cin >> N >> M;
	int lock_btn;
	for(int i=0; i<M; i++) {
		cin >> lock_btn;
		Lock[lock_btn] = true;
	}
	
	answer = abs(100-N);
	
	int tmp;
	for(int i=0; i<=1000000; i++) {
		if(check(i)) {
			tmp = abs(N-i) + to_string(i).size();
			answer = min(answer, tmp);
		}
	}
	
	cout << answer;
	return 0;
}
