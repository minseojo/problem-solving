#include <bits/stdc++.h>
using namespace std;

int a[1000][5];
bool check[5];
int result[1000];

void dfs(int pos, int idx) {
	if (pos == 3) {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			if (check[i]) sum += a[idx][i];
		}
		string str = to_string(sum);
		sum = str[str.length()-1]-'0';
		if (sum > result[idx]) {
			result[idx] = sum;
		}
		return;
	}
	
	for (int i = 0; i < 5; i++) {
		if (check[i]) continue;
		check[i] = true;
		dfs(pos+1, idx);
		check[i] = false;
	}
}
int main() {
	int n;
	cin >> n;

	int num;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <5; j++) {
			cin >>a[i][j];
		}
	}
	
	for (int i = 0; i < n; i++) {
		dfs(0, i);
	}
	
	int max_sum = 0, ans = n-1;
	for (int i = n-1; i >= 0; i--) {
		if (max_sum < result[i]) {
			max_sum = result[i];
			ans = i;
		}
	}
	cout << (ans+1) << "\n";
	return 0;
}