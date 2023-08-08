#include <iostream>
#include <cmath>
#define endl '\n'

using namespace std;

void hanoi(int n, int from, int mid, int to) {
    if (n == 1) {
        cout << from << " " << to << endl;
    } else {
        hanoi(n-1, from, to, mid);
        cout << from << " " << to << endl;
        hanoi(n-1, mid, from, to);
    }
}

int main() {
    int n;
    cin >> n;
    cout << (int) (pow(2, n)-1) << endl;
    hanoi(n, 1, 2, 3);
    return 0;
}