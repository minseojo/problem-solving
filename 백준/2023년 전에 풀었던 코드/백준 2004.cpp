#include <bits/stdc++.h>
using namespace std;

int fiveZero(int num) {
	int cnt=0;
	while(num>=5) {
		cnt+=num/5;
		num/=5;
	}
	return cnt;
}

int twoZero(int num) {
	int cnt=0;
	while(num>=2) {
		cnt+=num/2;
		num/=2;
	}
	return cnt;
}

int main() {
	int n, cnt=0, m;
	cin >> n >> m;
	int a=fiveZero(n), b=fiveZero(m), c=fiveZero(n-m);
	int a2=twoZero(n), b2=twoZero(m), c2=twoZero(n-m);
	cout << std::min(a-b-c,a2-b2-c2);
	
	return 0;
}
