#include <bits/stdc++.h>
#define ll long long
using namespace std;

ll gcd(ll a, ll b) {
	if (b == 0) return a;
	return gcd(b, a % b);
}

ll x, y;
void ext_gcd(ll a, ll b) {
	if (b == 0) {
		x = 1;
		y = 0;
		return;
	}
	
	ext_gcd(b, a % b);
	ll temp = y;
	y = x - (a/b)*y;
	x = temp;

}

int main() {
	ll tc;
	cin >> tc;
	while (tc--) {
		ll k, c;
		cin >> k >> c;
		
		if (gcd(k ,c) != 1) {
			cout << "IMPOSSIBLE\n";
			continue;
		}
		
		if (k == 1) {
			if (c == 1) {
				cout << "2\n";
			} else if (c > 1){
				cout << "IMPOSSIBLE\n";
			}
			continue;
		} 
		if (k != 1 && c == 1) {
			if (k+1 <= 1e9) {
				cout << k+1 << "\n";
			} 
			else {
				cout << "IMPOSSIBLE\n";
			}	
			continue;
		}
		
		x = 0, y = 0;
		ext_gcd(k, c);
		while (y * c <= x * k) {
			y += k;
		}
		
		if (y >= 1e9) {
			cout << "IMPOSSIBLE\n";
		} else {
			cout << y << "\n";
		}
	}
	
	return 0; 
}