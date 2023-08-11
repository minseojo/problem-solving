#include <bits/stdc++.h>
#define endl '\n'
#define MAX 22
using namespace std;

int arr[MAX];

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int n, x;
	string str;
	cin >> n;
	for(int i=0; i<n; i++) {
		cin >> str;
		if(str=="all") {
			for(int j=1; j<=20; j++) {
				arr[j]=1;
			}
		} 
		else if(str=="empty") {
			for(int j=1; j<=20; j++) {
				arr[j]=0;
			}
		}
		else {
			cin >> x;	
			if(str=="add") {
				arr[x]=1;
			} else if(str=="remove") {
				arr[x]=0;
			} else if(str=="check") {
				if(arr[x]==1) cout << 1 << endl;
				else cout << 0 << endl;
			} else if(str=="toggle") {
				if(arr[x]==0) arr[x]=1;
				else arr[x]=0;
			}
		}
	}
	
	return 0;
}