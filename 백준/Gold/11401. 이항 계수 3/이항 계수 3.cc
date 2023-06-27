#include <bits/stdc++.h>
#define ll long long
using namespace std;
const ll MOD = 1000000007LL;

ll pow(ll b, ll m) {
    ll ans = 1;
    while (m > 0) {
        if (m % 2 == 1) {
            ans = (ans * b) % MOD;
        }
        b = (b * b) % MOD;
        m /= 2;
    }
    return ans;
}

int main() {
    // a = n!
    // b = k! * (n-k)!
    int n, k;
    cin >> n >> k;
    // n!
    ll a = 1;
    for (int i = 1; i <= n; i++) {
        a = (a * i) % MOD;
    }

    ll b = 1;
    // k!
    for (int i = 1; i <= k; i++) {
        b = (b * i) % MOD;
    }
    // (n-k)!
    for (int i = 1; i <= n-k; i++) {
        b = (b * i) % MOD;
    }

    cout << (a % MOD) * (pow(b, MOD-2) % MOD) % MOD;
    return 0;
}

/*
nCk = n! / (k! * (n-k)!)
a = n!
b = (k! * (n-k)!)
a mod m / b mod m != a/b mod m
즉 b의 나머지 곱셈의 역원을 구하면 됨. a * (b^(-1)) mod m = 원하는 답.

** 중요 개념
여기서 m = 소수이므로
페르마 소정리 이용
b와 m 은 서로소 관계이다.
따라서 b^(m-1) mod m = 1이 항등하다.
**
양 변에 b^-1을 곱하면
b^(m-2) mod m = b^-1

즉, a * (b^(-1)) mod m = 원하는 답에 위 식을 대입하면
(a * b^(m-2)) mod m = 원하는 답.
= (a mod m) * (b^(m-2) mod m)
*/