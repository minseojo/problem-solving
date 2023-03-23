#include <bits/stdc++.h>
using namespace std;

int dp[41];

int fib(int n) {
    if (n==1 || n==2) return 1;
    else return (fib(n-1) + fib(n-2));
}

void fibTime(int n) {
	dp[1] = 1;
	for(int i=2; i<=n; i++) {
		dp[i] = dp[i-1] + dp[i-2];
	}
}

int main() {
	int n;
	cin >> n;
	fibTime(n);
	cout << dp[n] <<" " << n-2 ;

}