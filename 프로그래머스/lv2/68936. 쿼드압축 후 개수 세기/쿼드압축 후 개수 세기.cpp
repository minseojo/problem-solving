#include <string>
#include <vector>
#include <iostream>
using namespace std;

int ans[2];
void divide(vector<vector<int>>& arr, int sy, int sx, int size) {
    int zero = 0;
    int one = 0;

    for (int i = sy; i < sy + size; i++) {
        for (int j = sx; j < sx + size; j++) {
            if (arr[i][j] == 0) zero++;
            else one++;
        }
    }
    if (zero == 0 && one > 0) ans[1]++;
    else if (zero > 0 && one == 0) ans[0]++;
    else {
        if (size == 1) return;
        divide(arr, sy, sx, size/2); // 1
        divide(arr, sy, sx+size/2, size/2);// 2
        divide(arr, sy+size/2, sx, size/2); // 3
        divide(arr, sy+size/2, sx+size/2, size/2); // 4
    }

}

vector<int> solution(vector<vector<int>> arr) {
    divide(arr, 0, 0, arr[0].size());
    vector<int> answer;
    answer.push_back(ans[0]);
    answer.push_back(ans[1]);
    return answer;
}