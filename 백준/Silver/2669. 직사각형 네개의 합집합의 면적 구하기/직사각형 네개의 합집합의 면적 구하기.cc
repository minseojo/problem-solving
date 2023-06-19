#include <bits/stdc++.h>
using namespace std;

int area[101][101];
int main() {
	for (int i = 0; i < 4; i++) {
		int y, x, y2, x2;
		cin >> y >> x >> y2 >> x2;
		for (int j = y; j < y2; j++) {
			for (int k = x; k < x2; k++) {
				area[j][k]++;
			}
		} 
	}
	
	int result = 0;
	for (int i = 1; i <= 100; i++) {
		for (int j = 1; j <= 100; j++) {
			if (area[i][j] > 0) {
				result++;
			}
		}
	}
	cout << result;
	return 0;
}