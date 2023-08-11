#include <bits/stdc++.h>
using namespace std;

int n;
int a[1000][1000];
int degree[1000];
vector<int> v[1000];

void dfs(int idx) {
 
    for (int &i=v[idx][0]; i<v[idx].size()-1; i++) {
    	int x=v[idx][i+1];
        while(a[idx][x]>0) {
            a[idx][x]--;
            a[x][idx]--;
            dfs(x);        
        }
    }
    
	cout << idx+1 << " ";
    return;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
    cin >> n;
    for(int i=0; i<n; i++) {
    	v[i].push_back(0);
        for (int j=0; j<n; j++) {
            cin >> a[i][j];
            degree[i]+=a[i][j];
            if(a[i][j]>=1) {
            	v[i].push_back(j);
			}
        }
	}
    
    for (int i=0; i<n; i++) {
        if (degree[i]%2==1) {  // => 오일러 경로 
            cout << -1 << '\n'; //오일러 회로가 되기 위해서는 각각의 정점을 들어오고 나가야하므로 모두 짝수다. 
            return 0;
        }
    }
    dfs(0);
    return 0;
}
