#include <iostream>
#include <math.h>
using namespace std;

int max_sum[4];
int min_sum[4];
int a[4];

int main() {
    int n;
	cin >> n;
    for (int i = 1; i <= n; i++) {
		cin >> a[1] >> a[2] >> a[3];
		int t1 = max_sum[1], t2 = max_sum[2], t3 = max_sum[3];
		max_sum[1] = max(t1, t2) + a[1];
		max_sum[2] = max(t1, max(t2, t3)) + a[2];
		max_sum[3] = max(t2, t3) + a[3];

		t1 = min_sum[1], t2 = min_sum[2], t3 = min_sum[3];
		min_sum[1] = min(t1, t2) + a[1];
		min_sum[2] = min(t1, min(t2, t3)) + a[2];
		min_sum[3] = min(t2, t3) + a[3];
    }

	int max_ans = max(max_sum[3], max(max_sum[1], max_sum[2]));
	int min_ans = min(min_sum[3], min(min_sum[1], min_sum[2]));
	cout << max_ans << " " << min_ans;
    return 0;
}