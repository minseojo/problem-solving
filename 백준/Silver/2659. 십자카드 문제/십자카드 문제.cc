#include <iostream>
#include <math.h>
using namespace std;

bool check[10000];

int get_clock_num(int i, int j, int k, int l) {
    int result = 1e9;
    int a[4] = {i, j, k, l};
    for (int i = 0; i < 4; i++) {
        result = min(result, 1000 * a[i%4] + 100 * a[(i+1)%4] + 10 * a[(i+2)%4] + a[(i+3)%4]);
    }
    return result;
}

int main() {
    int a, b, c, d;
    cin >> a >> b >> c >> d;
    int clock_num = get_clock_num(a, b, c, d);

    int answer = 0;
    for (int i = 1; i < 10; i++) {
        for (int j = 1; j< 10; j++) {
            for (int k = 1; k < 10; k++) {
                for (int l = 1; l < 10; l++) {
                    int x = get_clock_num(i, j, k, l);
                    if (x < clock_num && !check[x]) {
                        check[x] = true;
                        answer++;
                    }
                }
            }
        }
    }
    cout << answer+1;
    return 0;
}