#include <bits/stdc++.h>
#define ll long long
using namespace std;

/*
처음 문제를 풀 때 신발끈 공식을 쓰고 싶었는데
좌표가 순차적으로 정렬을 어떻게 해야하지 싶었는데
문제에서 다각형을 이루는 순서대로 N개의 점의 x, y좌표가 주어진다. 라는 말이 있다.
즉 그냥 신발끈 공식 쓰면 된다.
*/

struct St {
    double y;
    double x;
};
vector<St> coordinate;

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        double y, x;
        cin >> x >> y;
        coordinate.push_back({x, y});
    }
    double sum = 0;
    for (int i = 0; i < n; i++) {
        double x = coordinate[i].x;
        double y;
        if (i == n-1) {
            y = coordinate[0].y;
        } else { 
            y = coordinate[i+1].y;
        }
        sum += (x * y);
    }

    for (int i = 0; i < n; i++) {
        double x;
        double y = coordinate[i].y;
        if (i == n-1) {
            x = coordinate[0].x;
        } else { 
            x = coordinate[i+1].x;
        }
        sum -= (x * y);
    }
    sum /= 2;
    cout << fixed;
    cout.precision(1);
    
    cout << abs(sum);

    return 0;
}