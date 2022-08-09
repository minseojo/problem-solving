#include <bits/stdc++.h>
#define ll long long
using namespace std;

ll solution(int a, int b, int c) {
	if(b == 0) return 1;
	if(b == 1) return a;
	
	ll ret;

	// 짝수 
	if(b%2 == 0) {
		ret = solution(a, b/2, c);
		return (ret * ret) % c;
	} 
	// 홀수 
	else {
		ret = a * solution(a, b-1, c);
		return ret % c;
	}
}

int main() {
	int A, B, C;
	cin >> A >> B >> C;
	cout << solution(A, B, C) % C;
	
	return 0;
}
