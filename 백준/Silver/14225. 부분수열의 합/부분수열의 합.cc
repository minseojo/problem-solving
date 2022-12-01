#include <bits/stdc++.h>
#define MAX 100001 * 20
using namespace std;

int n;
int number[20];
int check[MAX];

void solve(int index, int sum) {
	if(index > n || sum >= MAX) return;
	check[sum] = sum;
	solve(index + 1, sum);
	solve(index + 1, sum + number[index]);
	
	return;
}

int main() {
	cin >> n;
	
	memset(check, -1, sizeof(check));
	for(int i=0; i<n; i++) {
		cin >> number[i];
		check[number[i]] = number[i];
	}
	
	if(n != 1) solve(0, 0);
	for(int i=1; i<=MAX; i++) {
		if(check[i] == -1) {
			cout << i;
			break;
		}
	}
	
	return 0;
}