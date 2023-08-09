/*
1 100000000000000 
670121
*/

#include <iostream>
#include <set>
#include <queue>
#include <math.h>
using namespace std;

set<long long> ans;
const static long long INF = 1e14;

void makePrime(long long base, long long a, long long b) {
	if (base > INF) return;
	long long x = base * base;
	while (x <= b) {
		if (a <= x) ans.insert(x);
		if (x < INF / base) x *= base; // 오버플로우 방지. ex) (10^8)^3 > 2^63-1
		else break;
	}
}

bool isPrime[10000001];
void eratosthenes() {
	for (int i = 2; i <= sqrt(INF); i++) isPrime[i] = true;

	for (int i = 2; i <= sqrt(INF); i++) {
		if (isPrime[i]) {
			for (int j = i+i; j <= sqrt(INF); j+=i) {
				isPrime[j] = false;
			}
		}
	}
}

int main() {
	long long a, b;
	cin >> a >> b;
	eratosthenes();

	for (int i = 2; i <= sqrt(INF); i++) {
			if (isPrime[i]) {
				makePrime(i, a, b);
			}
	}
	cout << ans.size();
	return 0;
}