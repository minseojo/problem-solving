#include <bits/stdc++.h>
#define ll long long
#define endl "\n"
#define MAX 1000000001
#define MIN -1000000001
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

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, M;
    cin >> N >> M;
    for(int i=1; i<=N; i++) cin >> arr[i];
    for(int i=1; i<=4*N; i++) {
        tree[i] = MAX;
    }
    initMin(1, N, 1);

    for(int i=0; i<M; i++) {
        int a, b;
        cin >> a >> b;
        if(a>b) swap(a, b);
        cout << findMin(1, N, 1, a, b) << endl;
    }
    return 0;
}