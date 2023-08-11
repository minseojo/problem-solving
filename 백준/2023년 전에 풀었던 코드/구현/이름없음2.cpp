#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int n, v[1010][1010], nxt[1010];

void dfs(int cur){
    for(int &x=nxt[cur];x<=n;x++){ // 봤었던 곳까지는 기록해 놓아야 시간복잡도가 보장됩니다.
        while(x<=n && v[cur][x]){
            v[x][cur]--, v[cur][x]--;
            dfs(x);
        }
    }
    printf("%d ",cur);
}

int main(){
    scanf("%d",&n);
    for(int i=1;i<=n;i++) for(int j=1;j<=n;j++) scanf("%d",&v[i][j]);

    for(int i=1;i<=n;i++){
        int deg = 0;
        for(int j=1;j<=n;j++) deg += v[i][j];
        if(deg % 2) return !printf("-1");
    }

    for(int i=1;i<=n;i++) nxt[i] = 1;
    dfs(n);
}
