#include <bits/stdc++.h>
#define INF 1000000007
#define ll long long
using namespace std;

ll arr[1000001];
ll tree[1000001 * 4];

ll init(int start, int end, int node) {
	if (start == end) return tree[node] = arr[start];	
	int mid = (start+end)/2;
	return tree[node] = (init(start, mid, node*2)) * (init(mid+1, end, node*2+1)) % INF;
}

ll product(int start, int end, int node, int left, int right) {
	if (left > end || start > right) return 1;
	if (left <= start && end <= right) return tree[node];
	int mid = (start+end)/2;
	return product(start, mid, node*2, left, right) * product(mid+1, end, node*2+1, left, right) % INF;
}

ll update(int start, int end, int node, int index, int original, int diff) {
	if (start > index || index > end) return tree[node];

	if(start == end) {
		return tree[node] = diff;
	}	
	
	int mid = (start+end)/2;
	return tree[node] = update(start, mid, node*2, index, original, diff) * update(mid+1, end, node*2+1, index, original, diff) % INF;

}

int main() {	
	ios_base::sync_with_stdio(false);	
	cin.tie(NULL);
	cout.tie(NULL);
	int N, M, K;
	cin >> N >> M >> K;
	for(int i=1; i<=4*N; i++) {
		tree[i] = 1;	
	}
	for(int i=1; i<=N; i++) {
		cin >> arr[i];
	}
	
	init(1, N, 1);
	
	for(int i=0; i<M+K; i++) {
		ll a, b, c;
		cin >> a >> b >> c;
		if (a==1) {
			update(1, N, 1, b, arr[b], c);
			arr[b] = c;
		}
		else if (a==2) {
			cout << product(1, N, 1, b, c) << endl;
		}
	}
	
	return 0;
}