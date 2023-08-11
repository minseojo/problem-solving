#include <bits/stdc++.h>
using namespace std;

string A;
int B;
int a[11];
int answer=-1;
int ret[11];
bool visited[11];

void solve(int pos) {
	if(pos==A.size()) {
		int sum=0, cnt=0;
		bool flag=false;
		
		for(int i=0; i<A.size(); i++) {
			if(ret[i]>0) flag=true;
			if(flag) {
				sum+=ret[i]*pow(10, A.size()-i-1);
				cnt++;
			}
		}
		if(cnt==A.size() && sum>answer && sum<B) answer=sum;

		return;
	}
	
	for(int i=0; i<A.size(); i++) {
		if(visited[i]) continue;
		visited[i]=true;
		ret[pos]=a[i];
		solve(pos+1);
		visited[i]=false;
	}
}

int main() {
	cin >> A >> B;
	for(int i=0; i<A.size(); i++) {
		a[i] = A[i]-'0';
	}
	
	solve(0);
	cout << answer;
	return 0;
}
