#include <bits/stdc++.h>
#define MAX 15
using namespace std;

int n, answer=0;
int col[MAX];

bool possible(int row) {
	for(int i=0; i<row; i++) {
		if(col[row]==col[i] || abs(col[row]-col[i]) == row-i) 
			return 0;
	}

	return 1;
}

void n_queen(int row) {
	if(row==n) {
		answer++;
		return;
	}
	
	for(int i=0; i<n; i++) {
		col[row]=i;
		if(possible(row))
			n_queen(row+1);
	}
}

int main() {
	cin >> n;
	n_queen(0);
	cout << answer;
	return 0;
}
