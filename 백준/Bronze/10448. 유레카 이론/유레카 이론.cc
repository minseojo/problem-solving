#include <bits/stdc++.h>
using namespace std;

int main() {
	int tc;
	cin >> tc;
	while(tc--) {
		int K;
		cin >> K;
		bool isOk = false;
		for (int i = 1; i <= 45; i++) {
			for (int j = 1; j <= 45; j++) {
				for (int k = 1; k <= 45; k++) {
					int a = (i * (i+1)) / 2;
					int b = (j * (j+1)) / 2;
					int c = (k * (k+1)) / 2;
					if ((a + b + c) == K) isOk = true;
				}
			}
		}
		if (isOk) cout << 1 << endl;
		else cout << 0 << endl;
	}
    return 0;
}