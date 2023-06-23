#include <bits/stdc++.h>
using namespace std;

int a[100000];
int ascending[100000];
int descending [100000];

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	
	// 오름차순 찾기 
	int top = 0, count = 0;
	for (int i = 0; i < n; i++) {
		if (top <= a[i]) {
			top = a[i];
			count++;
		} else {
			top = a[i];
			count = 1;
		}
		ascending[i] = count;
	}
	
	// 내림차순 찾기 
	top = 100001 , count = 0;
	for (int i = 0; i < n; i++) {
		if (top >= a[i]) {
			top = a[i];
			count++;
		} else {
			top = a[i];
			count = 1;
		}
		descending[i] = count;
	}
	
	int answer = 0;
	for (int i = 0; i < n; i++) {
		answer = max(answer, ascending[i]);
		answer = max(answer, descending[i]);
	} 
	cout << answer;
	return 0;
}