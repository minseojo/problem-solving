#include <bits/stdc++.h>
#define MOD 1234567891
using namespace std;

int main() {
	cin.tie(0), cout.tie(0);
	ios::sync_with_stdio(0);
	
	int n, i=0;
	long long sum=0, x=1;
	string str;
	cin >> n >> str;
	
	while(i<n) {
		sum+=((str[i]-'a'+1)*x)%MOD;
		x=(x*31)%MOD; i++;
	}
	
	cout << sum%MOD;
	
	return 0;
}
