#include <bits/stdc++.h>
using namespace std;

int arr[22222];
int main() {
	int n;
	cin >> n;
	for(int i=0; i<n; i++) {
		cin >> arr[i];
	}
	
	long long min=9876543921, index=-1;
	for(int i=0; i<=10000; i++) {
		int sum=0;
		for(int j=0; j<n; j++) {
			sum+=abs(arr[j]-i);
		}
		if(min>sum) {
			index=i;
			min = sum;
		}
	}
	cout << index;
	return 0;
}
