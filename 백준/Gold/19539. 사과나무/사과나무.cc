#include <bits/stdc++.h>
using namespace std;

int main() {
	int n;
	cin >> n;
	int sum = 0;
	int twos = 0;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		sum += x;
		twos += x / 2;
	}
	
	if ((sum % 3) == 0 && (twos >= sum / 3)) {
		cout << "YES";
	} else {
		cout << "NO";
	}
	
	return 0;
}