#include <iostream>
#include <list>
using namespace std;

struct Point {
    int idx;
    int num;
};

int main() {
    list<Point> balloon;
    int N;
    cin >> N;
    for (int i = 1; i <= N; i++) {
        int num;
        cin >> num;
        balloon.push_back({i, num});
    }
 
    list<Point>::iterator iter = balloon.begin();
    while (N > 0) {
        int x = iter->num;
        cout << iter->idx << " ";
        iter = balloon.erase(iter);
        if (iter == balloon.end()) iter++;
        N--;
        if (x < 0) {
            x *= -1;
            for (int i = 0; i < x; i++) {
                if (iter == balloon.begin()) iter = balloon.end();
                iter--;
            }
        }
        else {
            for (int i = 0; i < x - 1;  i++) {
                iter++;
                if (iter == balloon.end()) iter = balloon.begin();
            }
        }
    } 
}