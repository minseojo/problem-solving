#include <bits/stdc++.h>
using namespace std;

int F, S, G, U, D;
bool visited[1000001];

int bfs() {
    int result = 0;
    queue<int> q;
    q.push(S);
    visited[S] = true;
    while(!q.empty()) {
        int size = q.size();
        while(size--) {
            int cur = q.front();
            q.pop();
            if (cur == G) return result;
            if (cur + U <= F && !visited[cur+U]) {
                visited[cur+U] = true;
                q.push(cur + U);
            }
            if (0 < cur - D && !visited[cur-D]) {
                visited[cur-D] = true;
                q.push(cur-D);
            }
        }
        result++;
    }

    return -1;
}
int main() {
    cin >> F >> S >> G >> U >> D;
    int x = bfs();
    if (x == -1) cout << "use the stairs";
    else cout << x;
    return 0;
}