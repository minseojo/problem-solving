//
//  22353.cpp
//  cpp
//
//  Created by 조민서 on 2023/06/22.
//

#include <bits/stdc++.h>
using namespace std;

int main() {
    double a, d, k;
    cin >> a >> d >> k;
    
    double winRate = d / 100.0;
    double answer = 0;
    double accumulate = 1.0;

    for (int i = 1; ; i++){
        if (winRate > 1.0) {
            answer += accumulate * i;
            break;
        }
        answer += accumulate * i * winRate;
        accumulate = (accumulate * (1 - winRate));
        winRate += (winRate * (k / 100.0));
    }
    cout.precision(7);
    cout << fixed;
    cout << answer  * a;
    
    return 0;
}