#include <bits/stdc++.h>
using namespace std;

int arr[100011];
bool check[100011];
bool visited[100011];
int cnt=0;

void dfs(int index) {	

	visited[index]=true;
	
	int next = arr[index];
	if(!visited[next]) 
		dfs(next);
	
	else if(!check[next]) {
		for(int i=next; i!=index; i=arr[i])
			cnt++;
		cnt++;
	}
	
	check[index]=true;
}

int main() {
	int tc, n;
	cin >> tc;
	
	while(tc--) {
		memset(arr, 0, sizeof(arr));
		memset(visited, false, sizeof(visited));
		memset(check, false, sizeof(check));
		
		cin >> n;
		for(int i=1; i<=n; i++) 
			cin >> arr[i];
		
		cnt=0;
		for(int i=1; i<=n; i++) {
			if(!visited[i])
				dfs(i);
		}
		
		cout << n-cnt << endl;
	}
	
	return 0;
}