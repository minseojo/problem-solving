#include <bits/stdc++.h>
using namespace std;

vector<int> v[100001];
bool visited[100001];
int answer[100001];
int n,m;

void f(int index) {
	visited[index]=true;
	
	for(int i=0; i<v[index].size(); i++) {
		int next = v[index][i];
		if(!visited[next]) {
			answer[next]=index;
			f(next);
		}
	}
}

int main() {
	scanf("%d", &n);
	int a,b;
	for(int i=0; i<n-1; i++) {
		scanf("%d %d", &a, &b);
		v[a].push_back(b);
		v[b].push_back(a);
	}
		
	f(1);
	for(int i=2; i<=n; i++)
		printf("%d\n", answer[i]);
	
	return 0; 
}
