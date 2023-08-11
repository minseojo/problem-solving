#include <bits/stdc++.h>
using namespace std;

int arr[1000011];
int n, s, answer=0;

void dfs(int sum, int index) {
	if(index==n) { // 이 조건이 없으면 중복을 다 더함 
		if(sum==s) answer++;
		return;
	}
	
	dfs(arr[index]+sum, index+1);
	dfs(sum, index+1);
}

int main() {
	cin >> n >> s;
	for(int i=0; i<n; i++)
		cin >> arr[i];
	
	if(s==0) answer--;  // s가 0인 인경우 어떤값도  더하지 않으면 추가하므로 하나를 뺸다
	  
	dfs(0,0);
		
	cout << answer;
}
