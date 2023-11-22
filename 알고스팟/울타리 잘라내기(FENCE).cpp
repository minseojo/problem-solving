#include <bits/stdc++.h>
using namespace std;

long long h[1000111];
long long ret;

int solve(long long left, long long right) {
	//판자가 1개인 경우 
	if (left == right) {
		return h[left];
	}
	long long mid = (left + right) / 2;
	//왼쪽, 오른쪽 분할 
	long long ret = max(solve(left, mid), solve(mid+1, right));

	long long low = mid;
	long long high = mid+1;
	long long height = min(h[low], h[high]);
	
	//중간부분에 걸친 경우 
	ret = std::max(ret, height*2);
	
	//양쪽으로 한 칸씩 확장
	//이때 왼쪽, 오른쪽 중 더 큰 쪽으로 확장한다.
	while (left < low || high < right) {
		//오른쪽으로 확장 
		if (high < right && (low == left || h[low-1] < h[high+1])) {
			high++;
			height = min(height, h[high]);
		}
		//왼쪽으로 확장 
		else {
			low--;
			height = min(height, h[low]);
		}
		// 확장한 후 사각형의 넓이 
		ret = max(ret, height * (high - low + 1));
	}
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);	
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	while (1) {
		cin >> n;
		if(n==0) break; 
		for (int i=0; i < n; i++) {
			cin >> h[i];
		}
		cout << solve(0, n-1) << "\n";
		memset(h, 0, sizeof(h));
	}
	return 0;
}
