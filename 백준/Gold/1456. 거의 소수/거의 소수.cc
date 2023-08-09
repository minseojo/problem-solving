#include <iostream>
#include <set>
#include <queue>
#include <math.h>
using namespace std;

set<long long> ans;
const static long long INF = 1000000000000000;

void makePrime(long long base, long long a, long long b) {
	if (base > INF) return;
	long long x = base * base;
	while (x <= b) {
		if (a <= x) ans.insert(x);
		if (x < INF / base) x *= base;
		else break;
	}
}
//1 100000000000000 
// 670121
bool isPrime[100000001];

int main() {
    long long a, b;
	cin >> a >> b;
	for (int i = 2; i <= sqrt(INF); i++) {
		if (isPrime[i]) continue;
		for (int j = i+i; j <= sqrt(INF); j+=i) {
			isPrime[j] = true; // true면 소수가 아님
		}
	}

	for (int i = 2; i <= sqrt(INF); i++) {
		if (!isPrime[i]) { // if 소수면
			makePrime(i, a, b);
		}
	}
	cout << ans.size();
    return 0;
}