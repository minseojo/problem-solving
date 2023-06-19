#include <bits/stdc++.h>
using namespace std;

bool area[101][101];
int main() {
	int result = 0;
	for (int i = 0; i < 4; i++) {
		int y, x, y2, x2;
		cin >> y >> x >> y2 >> x2;
		for (int j = y; j < y2; j++) {
			for (int k = x; k < x2; k++) {
				if(!area[j][k]) {
					area[j][k] = true;
					result++;
				}
			}
		} 
	}
	cout << result;
	return 0;
}