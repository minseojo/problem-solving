#include <bits/stdc++.h>
using namespace std;

int N, M, K;
long long leaf[1000001];
long long tree[1000001 * 4];

long long init(int start, int end, int node) {
	if(start == end) return tree[node] = leaf[start];
	
	int mid = (start + end) / 2;
	return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
}

//left ~ right 합 구하는 구간 
long long prefixSum (int start, int end, int node, int left, int right) { 
	if(left > end || right < start) return 0;
	if(left <= start && end <= right) return tree[node];
	
	int mid = (start + end) / 2;
	return prefixSum(start, mid, node * 2, left, right) + prefixSum(mid + 1, end, node * 2 + 1, left, right); 
}

void update(int start, int end, int node, int index, long long diff) {
	if(index < start || index > end) return;
	
	tree[node] += diff;
	if(start == end) return;
	
	int mid = (start + end) / 2;
	update(start, mid, node * 2, index, diff);
	update(mid + 1, end, node * 2 + 1, index, diff);
} 

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);
	
	cin >> N >> M >> K;
	
	for(int i=1; i<=N; i++) {
		cin >> leaf[i];
	}

	init(1, N, 1);
	
	long long a, b, c;
	for(int i = 0; i < M + K; i++) {
		cin >> a >> b >> c;
		if(a == 1) {
			long long diff = c - leaf[b];
			leaf[b] = c;
			update(1, N, 1, b, diff);
		} else {
			cout << prefixSum(1, N, 1, b, c) << endl;
		}
	}
}