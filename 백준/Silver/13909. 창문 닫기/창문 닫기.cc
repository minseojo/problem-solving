#include <iostream>
#include <math.h>
using namespace std;

int main() {
	long long n;
	cin >> n;
	int ans = 0;
	for (long long i = 1; i*i <= n; i++) {
		ans++;
	}
	cout << ans;
    return 0;
}