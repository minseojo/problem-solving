#include <bits/stdc++.h>
using namespace std;

int tower[500001];
int result[500001];

struct St {
	int value;
	int index;
};

struct cmp {
	bool operator()(St a, St b) {
		return a.value > b.value;
	}
};
priority_queue<St, vector<St>, cmp> pq;

int main() {
	int n;
	cin >> n;
	for (int i = 0; i< n; i++) {
		cin >> tower[i];
	}

	pq.push({tower[n-1], n});
	for (int i = n-2; i >= 0; i--) {
		while(!pq.empty()) {
			int value = pq.top().value;
			int index = pq.top().index;
			if (value <= tower[i]) {
				result[index] = i+1;
				pq.pop();
			} else {
				break;
			}
		}
		pq.push({tower[i], i+1});

	}
	for (int i = 1; i <= n; i++) {
		cout << result[i] << " ";
	}
	return 0;
}