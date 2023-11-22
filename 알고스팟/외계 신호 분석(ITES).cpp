#include <bits/stdc++.h>
using namespace std;

int solve(const vector<int>& signals, int k, int n) {
	int ret=0, tail=0, rangeSum=signals[0];
	for(int head=0; head<signals.size(); head++) {
		while(rangeSum<k && tail+1<signals.size())
			rangeSum+=signals[++tail];
			
		if(rangeSum==k) ret++;
		
		rangeSum-=signals[head];
	}
	return ret;	
}

int main() {
	int x=pow(2,32);
	vector<int> a(5000001);
	a[0] = 1983;
	for(int i=1; i<=5000000; i++) {
		a[i] = (a[i-1]*214013+2531011)%x;
	}
	cout << a[2];
	int tc;
	cin >> tc;
	while(tc--) {
		int k, n;
		cin >> k >> n;
		cout << solve(a, k, n) << endl;
	}
	
	return 0;
} 
