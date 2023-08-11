#include <bits/stdc++.h>
using namespace std;

char arr[6][6];
int dy[4]={0,0,1,-1};
int dx[4]={1,-1,0,0};
int cnt=0;
bool answer[1000000];

void dfs(int y, int x, string s) {
	if(y<0 || x<0 || y>=5 || x>=5) return;
	if(s.length()>7) return;
	
	if(s.length()==6) {
		int x=stoi(s);
		if(answer[x]==false) {
		//	cout << x << endl;
			answer[x]=true;
			cnt++;
		}
		return;
	}

	for(int i=0; i<4; i++) {
		dfs(y+dy[i], x+dx[i], s+arr[y][x]);
	}	
}

int main() {
	for(int i=0; i<5; i++) {
		for(int j=0; j<5; j++) {
			cin >> arr[i][j];
		}
	}

	for(int i=0; i<5; i++) {
		for(int j=0; j<5; j++) {
			dfs(i, j, "");
		}
	}
	
	cout << cnt;
} 
