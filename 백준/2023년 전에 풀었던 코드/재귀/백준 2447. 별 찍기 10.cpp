#include <bits/stdc++.h>
using namespace std;

int n;
void star(int y, int x, int size) {
	if((y/size)%3==1 && (x/size)%3==1) {
		cout << " ";
	} else {
		if(size/3==0) cout << "*";
		else star(y, x, size/3);
	}
}

int main() {
	cin >> n;
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			star(i, j, n);
		}
		cout << endl;
	}	
}
