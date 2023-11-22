#include <iostream>
#include <queue>
using namespace std;

priority_queue<int> maxPq;
priority_queue<int, vector<int>, greater<int>> minPq;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int n;

    cin >> n;
    for (int i = 0; i < n; i++) {
        int number;
        cin >> number;
        if (maxPq.size() - minPq.size() < 1) {
            maxPq.push(number);
        } else {
            minPq.push(number);
        }
        while (!minPq.empty() && maxPq.top() > minPq.top()) {
            int maxPqTop = maxPq.top();
            int minPqTop = minPq.top();
            maxPq.pop();
            minPq.pop();
            maxPq.push(minPqTop);
            minPq.push(maxPqTop);
        }

        cout << maxPq.top() << "\n";
    }
    return 0;
}