//
//  main.cpp
//  cpp
//
//  Created by 조민서 on 2023/06/22.
//

#include <bits/stdc++.h>

using namespace std;

double score[1000];

int main() {
    int tc;
    cin >> tc;
    while(tc--) {
        int n, pass = 0;
        double avg = 0.0;
        cin >> n;
        memset(score, 0, sizeof(score));
        for (int i = 0; i < n; i++) {
            cin >> score[i];
            avg += score[i];
        }
        avg /= ((double) n);
        for (int i = 0; i < n; i++) {
            if (avg < score[i]) {
                pass++;
            }
        }
        double answer = ((double) pass / (double) n) * 100 + 0.00005;
        cout.precision(3);
        cout << fixed;
        cout << answer << "%\n";
        //printf("%0.3lf%%\n", answer);
    }
    return 0;
}