#include <bits/stdc++.h>
using namespace std;

int piece[6] = {1, 1, 2, 2, 2, 8};

int main() {
	for(int i=0; i<6; i++) {
		int number;
		cin >> number;
		piece[i] -= number;
		cout << piece[i] << " ";
	}
	return 0;
}