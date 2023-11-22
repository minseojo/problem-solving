#include <bits/stdc++.h>
using namespace std;

int main() {
	long long N;
	cin >> N;
	int x = N % 10;
	if (x == 0 || x == 2 || x == 5 || x == 7) cout << "CY";
	else cout << "SK";
	return 0;
}