#include <bits/stdc++.h>
using namespace std;

vector<int> v[100001];
bool visited[100001];

int n, root, del, cnt=0;

void delVisted(int index) {
	visited[index]=true;	
	
	for(int i=0; i<v[index].size(); i++) {
		int next = v[index][i];
		if(!visited[next]) {
			delVisted(next);
		}
	}
}

void answer(int index) {
	visited[index]=true;
	
	int child=0;
	for(int i=0; i<v[index].size(); i++) {
		int next = v[index][i];
		if(!visited[next]) {
			answer(next);
			child++;
		}
	}
	if(child>0) return;
	else cnt++;
}

int main() {
	scanf("%d", &n);
	int x;
	for(int i=0; i<n; i++) {
		scanf("%d", &x);
		if(x==-1) root=i;
		else {
			v[x].push_back(i);
		}
	}	 
	
	scanf("%d", &del);
	delVisted(del);
	
	if(root==del) cout << 0;
	else {
		answer(root);
		cout << cnt;
	}

	return 0; 
}