#include <iostream>
using namespace std;

const int INF = 1e6;

bool isNotPrime[1000001];
void eratosthenes() {
    isNotPrime[1] = true;
    for (int i = 2; i <= INF; i++) {
        if (isNotPrime[i]) continue;
        for (int j = i+i; j <= INF; j+=i) {
            isNotPrime[j] = true;
        }
    }
}

int main() {
    int a, b;
    cin >> a >> b;
    eratosthenes();
    for (int i = a; i <= b; i++) {
        if (!isNotPrime[i]) cout << i << '\n';
    }
    return 0;
}