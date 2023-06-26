#include <bits/stdc++.h>
using namespace std;

int gcd(int a, int b) {
	if (b == 0) return a;
	return gcd(b, a % b);
}

int main() {
	int G, L; //최대공약수, 최소공배수 
	cin >> G >> L;
	
	int divide = L / G;
	int a = 0, b = 0;
	int result_a = 1e9, result_b = 1e9;
	
	for (int i = 1; i * i <= divide; i++) {
		if ((divide % i) == 0) {
			a = i;
			b = divide / i;
		} else {
			continue;
		}
		
		if (gcd(a, b) == 1) {
			if (result_a + result_b > a + b) {
				result_a = a;
				result_b = b;
			}
		}	
	}
	
	cout << result_a * G << " " << result_b * G;
	return 0; 
}