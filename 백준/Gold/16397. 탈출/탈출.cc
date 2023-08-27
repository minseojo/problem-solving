#include <bits/stdc++.h>
#define MAX 100000
using namespace std;

int N, T, G;
bool visited[MAX];

int BuntonB(int x) {
    string str = to_string(x * 2);
    if ('0' < str[0] && str[0] <= '9') {
        str[0] = ((str[0] - '0') - 1) + '0';
    }
    int num = stoi(str);
    return num;
}

int BFS() {
    queue<int> q;
    q.push(N);
    visited[N] = true;
    int result = 0;
    while (!q.empty()) {
        int size = q.size();
        if (result > T) return -1;
        while (size--) {
            int front = q.front();
            q.pop();
            if (front == G) return result;

            if (front + 1 < MAX && !visited[front + 1]) {
                visited[front + 1] = true;
                q.push(front + 1);
            }
            
            if (front * 2 < MAX) {
                int b_num = BuntonB(front);
                if (!visited[b_num]) {
                    visited[b_num] = true;
                    q.push(b_num);
                }
            }
        }
        result++;
    }
    return -1;
}

int main() {
    cin >> N >> T >> G;
    int ans = BFS();
    if (ans == -1) cout << "ANG" << "\n";
    else cout << ans << "\n";
    return 0;
}