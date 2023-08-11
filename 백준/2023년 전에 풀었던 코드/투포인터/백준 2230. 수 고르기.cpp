#include <bits/stdc++.h>
using namespace std;

int N, M;
vector<int> A;

int main() {
	cin >> N >> M;
	
	int num;
	for(int i = 0; i < N; i++) {
		cin >> num;
		A.push_back(num);
	}
	sort(A.begin(), A.end());

	int l = 0, r = 1;
	long long sum = 0, answer = 1e10, dif = 1e10;
	while(l < r && r < N) {
		sum = A[r] - A[l];
	
		if(sum == M) {
			dif = A[r]-A[l];
			answer = min(answer, dif);
			r++;
		} 
		else if(sum > M) {
			dif = A[r]-A[l];
			answer = min(answer, dif);
			l++;
		}
		else if(sum < M) {
			r++;
		}
		
		if(l == r) r++;
	}
	
	cout << answer;
	return 0;
}
