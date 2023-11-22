#include <bits/stdc++.h>
#define MAX 100
using namespace std;

int a[MAX];
bool plug[MAX];
int unplug[MAX];

int main() {
	int N, K;
	cin >> N >> K;
	for (int i = 0; i < K; i++) {
		cin >> a[i];
	}
	
	int plug_cnt = 0, ans = 0;
	for (int i = 0; i < K; i++) {
		int x = a[i];
		
		if (plug[x]) {
			continue;
		}
		
		if (plug_cnt < N) {
			plug[x] = true;
			plug_cnt++;
			continue;
		}
		
		for (int i = 1; i <= MAX; i++) unplug[i] = MAX;
		for (int j = i + 1; j < K; j++) {
			if (plug[a[j]]) {
				if (unplug[a[j]] == MAX) unplug[a[j]] = j;
				else continue;
			}
		}

		int unplug_idx = -1, idx = 0; 
		for (int j = 1; j <= MAX; j++) {
			if (plug[j] && unplug[j] > idx) {
				unplug_idx = j;
				idx = unplug[j];
			}
		}
		plug[unplug_idx] = false;
		plug[x] = true;
		ans++;
	}
	cout << ans;
	return 0;
}