#include <bits/stdc++.h>

using namespace std;

int a[1000000];
int b[1000000];
int answer[1000000];

int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	for(int i=0; i<n; i++) scanf("%d",&a[i]);
	for(int i=0; i<m; i++) scanf("%d",&b[i]);
	
	int curA=0, curB=0, cur=0;
	while(curA<n && curB<m) {
		if(a[curA]<b[curB]) answer[cur++] = a[curA++];
		else answer[cur++] = b[curB++];
	}

	while(curA<n) answer[cur++] = a[curA++];
	while(curB<m) answer[cur++] = b[curB++];
	
	for(int i=0; i<n+m; i++) 
		printf("%d ", answer[i]);
}
