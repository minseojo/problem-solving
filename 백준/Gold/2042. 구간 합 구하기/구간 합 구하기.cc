#include <bits/stdc++.h>
#define ll long long
using namespace std;

ll arr[1000001];
ll tree[1000001 * 4];

ll init(int start, int end, int node) {
	if (start == end) return tree[node] = arr[start];	
	int mid = (start+end)/2;
	return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
}

ll sum(int start, int end, int node, int left, int right) {
	if (left > end || start > right) return 0;
	if (left <= start && end <= right) return tree[node];
	int mid = (start+end)/2;
	return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
}

void update(int start, int end, int node, int index, ll diff) {
	if (start > index || index > end) return;
	
	tree[node] += diff;
	if(start == end) return;

	int mid = (start+end)/2;
	update(start, mid, node*2, index, diff);
	update(mid+1, end, node*2+1, index, diff);
}

int main() {
	int N, M, K;
	cin >> N >> M >> K;
	for(int i=1; i<=N; i++) cin >> arr[i];
	
	init(1, N, 1);
	
	for(int i=0; i<M+K; i++) {
		ll a, b, c;
		cin >> a >> b >> c;
		if (a==1) {
			ll diff = c-arr[b];
			arr[b] = c;
			update(1, N, 1, b, diff);
		}
		else if (a==2) {
			cout << sum(1, N, 1, b, c) << endl;
		}
	}
	
	return 0;
}
