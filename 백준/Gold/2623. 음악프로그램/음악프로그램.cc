#include <iostream>
#include <vector>
using namespace std;

vector<int> adj[1001];
int dag[1001];
bool visited[1001];
vector<int> ans;


void dfs(int here) {
    visited[here] = true;
    for (int i = 0; i < adj[here].size(); i++) {
        int next = adj[here][i];
        dag[next]--;
        if (dag[next] == 0) {
            ans.push_back(next);
            dfs(next);
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int k;
        cin >> k;
        vector<int> v;
        for (int j = 0; j < k; j++) {
            int num;
            cin >> num;
            v.push_back(num);
        }

        for (int j = 1; j < v.size(); j++) {
            int prev = v[j-1], next = v[j];
            adj[prev].push_back(next);
            dag[next]++;
        }
    }
    //  1 2, 2 4        12435
    for (int i = 1; i <= n; i++) {
        if (dag[i] == 0 && !visited[i]) {
            ans.push_back(i);
            dfs(i);
        }
    }
    if (ans.size() == n) {
        for (int i : ans) {
            cout << i << endl;
        }
    } else {
        cout << 0 << endl;
    }

    return 0;
}