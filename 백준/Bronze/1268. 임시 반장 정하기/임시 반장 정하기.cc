#include <bits/stdc++.h>
using namespace std;

int studentClass[1000][5]; // 학생수, 1~5 학년 반
bool sameClass[1000];

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 5; j++) {
            cin >> studentClass[i][j];
        }
    }

    int maxSameClass = 0, ans = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < n; k++) {
                if (i == k) continue;
                if (studentClass[i][j] == studentClass[k][j]) {
                    sameClass[k] = true;
                }
            }
        }
        int same = 0;
        for (int j = 0; j < n; j++) {
            if (sameClass[j]) same++;
        }
        if (same > maxSameClass) {
            ans = i;
            maxSameClass = same;
        }
        memset(sameClass, 0, sizeof(sameClass));
    }

    cout << (ans+1) << "\n";
    return 0;
}