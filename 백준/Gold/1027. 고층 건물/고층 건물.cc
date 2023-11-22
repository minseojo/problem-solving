#include <bits/stdc++.h>
#define MAX 50
using namespace std;

int building[MAX];
int N;

int check(int cur) {
    int result = 0;

    double mn_gradient = 1e9; // 왼쪽
    double height = building[cur];
    for (int pre = cur - 1; pre >= 0; pre--) {
        double pre_height = building[pre];
        double gradient = (height - pre_height) / (cur - pre);
        if (mn_gradient > gradient) {
            mn_gradient = gradient;
            result++;
        }
    }
    double mx_gradient = -1e9; // 오른쪽
    for (int next = cur + 1; next < N; next++) {
        double next_height = building[next];
        double gradient = (next_height - height) / (next - cur);
        if (mx_gradient < gradient) {
            mx_gradient = gradient;
            result++;
        }
    }
    return result;
}

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) cin >> building[i];
    
    int ans = 0;
    for (int i = 0; i < N; i++) {
        ans = max(ans, check(i));
    }

    cout << ans << "\n";
    return 0;
}