#include <bits/stdc++.h>
using namespace std;

int dist[51][51];

int main() {
	int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++){
            if(i == j) continue;
            else dist[i][j] = 1e9;
        }
    }
    
    while(1) {
    	int u, v;
        cin >> u >> v;
        if (u == -1 && v == -1) break;
        dist[u][v] = 1;
        dist[v][u] = 1;
    }
    
    for (int k = 1; k <= n; k++) {
    	for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= n; j++) {
            	dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);	
            }
		}	
	}
        
    int result = 1e9;
    vector<int> v;
    for(int i = 1; i <= n; i++) {
        int temp = 0;
        for (int j = 1; j <= n; j++) {
            temp = max(temp, dist[i][j]);
        }
        if (temp < result) {
            v.clear();
            result = temp;
            v.push_back(i);
        }
        else if (temp == result) {
            v.push_back(i);
        }
    }
    
    sort(v.begin(),v.end());
    cout << result << " " << v.size() << endl;
    for(int i=0; i < v.size(); i++) {
        cout << v[i]<<" ";
    }
    return 0;
}