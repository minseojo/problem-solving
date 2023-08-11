#include <bits/stdc++.h>
#define MAX 1000000
using namespace std;

int a[MAX];
int prefixSum[MAX];

int main() {
	int n = 0, s = 0;
	cin >> n >> s;
	
	for(int i=1; i<=n; i++) {
		cin >> a[i];
		prefixSum[i] = a[i] + prefixSum[i-1];
	}

	
	int l = 0, r = 1, sum = 0;
	int answer = MAX;

	while(l <= r && r <= n) {
		sum = prefixSum[r] - prefixSum[l];
		if(sum == s) {
			answer = min(answer, r-l);
			r++;
		}	
		else if(sum < s) {
			r++;
		}
		else if(sum > s) {
			answer = min(answer, r-l);
			l++;
		}
	}
	
	if(answer == MAX) cout << 0;
	else cout << answer;
	return 0;
}
