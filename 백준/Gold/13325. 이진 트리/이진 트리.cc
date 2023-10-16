#include <iostream>
#include <math.h>
using namespace std;

int n;
int nodes[4200000];
int MAX_NODE;

int myAbs(int x) {
    if (x < 0) return x * -1;
    return x;
}


int f(int here) {
    if (here > MAX_NODE) return 0;

    int left_sum = f(here * 2) + nodes[here * 2];
    int right_sum = f(here * 2 + 1) + nodes[here * 2 + 1];
    int dif = myAbs(left_sum - right_sum);
    if (left_sum > right_sum) {
        nodes[here * 2 + 1] += dif; 
    } else {
        nodes[here * 2] += dif;
    }

    return max(left_sum, right_sum); 
}

int main() {
    cin >> n;
    for (int i = 2; i < pow(2, n + 1); i++) {
        cin >> nodes[i];
    }
    MAX_NODE = pow(2, n + 1);
    f(1);
    int ans = 0;
    for (int i = 2; i < pow(2, n + 1); i++) {
        ans += nodes[i];
    }
    cout << ans;
    return 0;
}