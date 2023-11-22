#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;
    int ly = left / n, lx = left % n;
    int ry = right / n, rx = right % n;

    while (1) {
        if (lx <= ly) answer.push_back(ly+1);
        else answer.push_back(lx+1);
        lx++;
        if (ly >= ry && lx >= rx) break;
        if (lx == n) {
            lx = 0;
            ly++;
        }
    }
    if (lx <= ly) answer.push_back(ly+1);
    else answer.push_back(lx+1);
    return answer;
}
/*
123 if (right < n) left
223
333

12345 0~n-1
22345 n~2n-1
33345 2n~ 3n-1
44445
55555
1~n
22~n
333~n
4444~n
55555~n
*/