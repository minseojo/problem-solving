#include <bits/stdc++.h>
using namespace std;

int arr[51];

int main() {
	int s, n;
	cin >> s;
	for(int i=0; i<s; i++)
		cin >> arr[i];
	cin >> n;
	
	sort(arr, arr+s);
	
	int a ,b;
	if(s==1) {
		cout << 0;
		return 0;
	}
	for(int i=0;i <s; i++) {
		if(n==arr[i]) {
			cout << 0;
			return 0;
		}
		if(n>arr[i] && n<arr[i+1]) {
			a=arr[i];
			b=arr[i+1];
		}
	}
	
	int a2=n-1-a;
	int b2=b-n-1;
	cout << a2*b2+a2+b2;
} 
