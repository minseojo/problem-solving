#include <bits/stdc++.h>
#define ll long long
#define endl "\n"
#define MAX 1000000001

using namespace std;

ll arr[1000001];
ll tree[1000001 * 4];

ll initMin(int start, int end, int node) {
	if (start == end) return tree[node] = arr[start];	
	int mid = (start+end)/2;
	return tree[node] = min(initMin(start, mid, node*2), initMin(mid+1, end, node*2+1));
}

ll findMin(int start, int end, int node, int left, int right) {
	if (left > end || start > right) return MAX;
	if (left <= start && end <= right) return tree[node];
	int mid = (start+end)/2;
	return min(findMin(start, mid, node*2, left, right), findMin(mid+1, end, node*2+1, left, right));
}

ll update(int start, int end, int node, int index, int diff) {
	if (start > index || index > end) return tree[node];

	if (start == end) return tree[node] = diff;
	
	int mid = (start+end)/2;
	ll l = update(start, mid, node*2, index, diff);
	ll r = update(mid+1, end, node*2+1, index, diff);
	tree[node] = min(l, r);
	return tree[node];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int N, M;
    cin >> N;
    for(int i=1; i<=N; i++) cin >> arr[i];
    for(int i=1; i<=4*N; i++) tree[i] = MAX;
    
	    
    cin >> M;
    initMin(1, N, 1);

    for(int i=0; i<M; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        if(a == 1) {
        	arr[b] = c;
        	update(1, N, 1, b, c);
		} else {
        	cout << findMin(1, N, 1, b, c) << endl;	
		}
    }
    return 0;
}