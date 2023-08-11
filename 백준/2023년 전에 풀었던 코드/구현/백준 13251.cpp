#include <bits/stdc++.h>
using namespace std;

int arr[51];

int main() {
	int m, k, sum=0;
	cin >> m;
	for(int i=1; i<=m; i++) {
		cin  >> arr[i];
		sum+=arr[i];
	}
	arr[0]=sum;
	cin >> k;
	
	double MOD=1, answer=0, s;
	for(int i=0; i<=m; i++) {
		s=1;
		for(int j=0; j<k; j++) {
			if(i==0)
				MOD*=(arr[i]-j);
			else {
				s*=(arr[i]-j);
			}
		}
		if(i!=0) answer+=s;
	}
	
	printf("%.10f", answer/MOD);
	return 0;
}
