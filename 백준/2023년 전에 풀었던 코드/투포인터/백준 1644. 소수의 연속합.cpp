#include <bits/stdc++.h>
#define MAX 4000000
using namespace std;

int n;
vector<int> prime;
int visited[MAX+1];
long long prefixSum[MAX];

void makePrime() {
	visited[1] = 1;
	for(int i = 2; i <= sqrt(MAX); i++) {
		for(int j = i+i; j <= MAX; j+=i) {
			visited[j] = 1;
		}
	}
	
	for(int i = 2; i <= MAX; i++) {
		if(visited[i] != 1) prime.push_back(i);
	}
}

int solve() {
	prefixSum[1] = prime[0];
	for(int i=2; i<=prime.size(); i++) {
		prefixSum[i] += prime[i-1] + prefixSum[i-1];

	}
	
	int l = 0, r = 1, answer = 0;
	long long sum = 0;

	while(l <= r && r <= prime.size()) {
		sum = prefixSum[r] - prefixSum[l];
		if(sum == n) {
			answer++;
			r++;
		}
		else if(sum > n) l++;
		else if(sum < n) r++;
	}
	
	return answer;
}
int main() {
	cin >> n;
	makePrime();
	
	cout << solve();
} 
