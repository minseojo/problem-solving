#include <bits/stdc++.h>
using namespace std;

int arr[1001];

int main()
{
	long n, sum = 0;
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	sort(arr, arr + n);
	if (arr[0] != 1) cout << 1;
	else {
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum + 2 <= arr[i + 1]) break;
		}
		cout << sum + 1;
	}
}