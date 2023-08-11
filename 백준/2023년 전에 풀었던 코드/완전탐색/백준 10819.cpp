#include <bits/stdc++.h>
using namespace std;

int n, mx=0;
int arr[10];
int tmp[10];
bool check[10];

void f(int pos) {
	if(pos==n) {
		int sum=0;
		for(int i=0; i<n-1; i++) {
			sum+=abs(tmp[i]-tmp[i+1]);
		}
		if(sum>mx) mx=sum;
		return;
	}
	
	for(int i=0; i<n; i++) {
		if(!check[i]) {
			check[i]=true;
			tmp[pos]=arr[i];
			f(pos+1);
			check[i]=false;
		}
	}
}

int main() {
	cin >> n;
	for(int i=0; i<n; i++)
		cin >> arr[i];
		
	f(0);
	
	cout << mx;
}
