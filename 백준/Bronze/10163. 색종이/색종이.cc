#include <iostream>
using namespace std;

int block[1112][1112];
int result[1112];

int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        int y, x, w, h;
        cin >> y >> x >> h >> w;
        for (int row = y; row < y + h; row++) {
            for (int column = x; column < x + w; column++) {
                block[row][column] = i;
            }
        }
    }
    for (int row = 0; row <= 1111; row++) {
        for (int column = 0; column <= 1111; column++) {
            int x = block[row][column];
            if (x == 0) continue;
            result[x]++;
            //cout << row << " " << column << " "<<x<< endl; 
        }
    }
    for (int i = 1; i <= n; i++) {
        cout << result[i] << endl;
    }
}