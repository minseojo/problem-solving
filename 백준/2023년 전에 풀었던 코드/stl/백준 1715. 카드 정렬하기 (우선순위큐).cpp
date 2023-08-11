#include <bits/stdc++.h>
using namespace std;

priority_queue<int, vector<int>, greater<int> > pack;

int main() {
	int N=0;
	cin >> N;
	
	int card;
	for(int i=0; i<N; i++) {
		cin >> card;
		pack.push(card);
	}
	
	int a=0, b=0, answer = 0;
	while(pack.size() > 1) {
		a = pack.top(); 
		pack.pop();
		b = pack.top();
		pack.pop();
		
		answer += a+b;
		pack.push(a+b);
	}
	
	cout << answer;
	return 0;
} 
