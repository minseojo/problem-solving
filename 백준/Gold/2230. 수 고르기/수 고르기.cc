#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const long long int MAX = 21000000000;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long long int n, m, left=0, right=1, temp, ans = MAX;
    vector<int> arr;

    cin >> n >> m;

    for (int i=0; i<n; i++) {
        cin >> temp;
        arr.push_back(temp);
    }

    sort (arr.begin(), arr.end());

    while (1) {
        if (left >= n || right >= n) break;
        temp = arr[right] - arr[left];
        if (temp < m) right++;
        else {
            ans = min(ans, temp);
            left++;
        }
    }

    cout << ans << "\n";
    return 0;
}