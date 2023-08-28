#include <bits/stdc++.h>
#define MAX 1000
using namespace std;

int main() {
	long long N;
	cin >> N;
	int x = N % 7;
	if (x == 0 || x == 2) cout << "CY";
	else cout << "SK";
	return 0;
}