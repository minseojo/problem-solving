#include <iostream>
using namespace std;

int button[3] = {300, 60, 10};
int click[3];

int main() {
    int T;
    cin >> T;
    while (T > 0) {
        for (int i = 0; i < 3; i++) {
            if (T / button[i] > 0) {
                click[i] += T / button[i];
                T %= button[i];
                break;
            }
            if (i == 2) {
                cout << -1;
                return 0;
            }
        }
    }
    for(int i = 0; i < 3; i++) {
        cout << click[i] << " ";
    }
    return 0;
}