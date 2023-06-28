#include <bits/stdc++.h>
using namespace std;

int a[3];
int main() {
    for (int i = 0; i < 3; i++) {
        int num;
        cin >> num;
        a[i] = num;
    }
    sort(a, a+3);
    int c = a[2];
    a[2] = a[0] + a[1];
    if (c >= a[2]) {
        c = a[2] - 1;
    }

    cout << a[0] + a[1] + c;
    return 0;
}