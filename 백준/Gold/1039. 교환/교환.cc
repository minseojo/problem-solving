#include <bits/stdc++.h>
#define MAX 1000000
using namespace std;

int N, K;
bool visited[11][MAX + 1];
queue<int> q;
int ans;

string swap(string str, int i, int j) {
    char temp = str[i];
    str[i] = str[j];
    str[j] = temp;
    return str;
}

void calculate(int index, int x) {
    string str = to_string(x);
    for (int i = 0; i < str.size(); i++) {
        for (int j = i + 1; j < str.size(); j++) {
            string temp = swap(str, i, j);

            if (temp[0] == '0') continue;

            int num = stoi(temp);
            if (!visited[index][num]) {
                visited[index][num] = true;
                q.push(num);
            }
        }
    }
}

bool BFS() {
    q.push(N);
    int cnt = 0;
    while (!q.empty()) {
        int size = q.size();
        while (size--) {
            int front = q.front();
            q.pop();
            calculate(cnt, front);
        }
        cnt++;
        if (cnt == K) {
            while (!q.empty()) {
                ans = max(ans, q.front());
                q.pop();
            }
            return true;
        }
    }

    return false;
}

int main() {
    cin >> N >> K;
    if (N < 10 || N < 100 && N % 10 == 0) {
        cout << -1 << "\n";
        return 0;
    }

    if (BFS()) cout << ans << "\n";
    else cout << -1 << "\n";

    return 0;
}