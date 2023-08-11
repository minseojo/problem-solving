#include <bits/stdc++.h>
using namespace std;

char arr[50][50];

int main() {
	int y, x;
	cin >> y >> x;
	for(int i=0; i<y; i++) {
		for(int j=0; j<x; j++)
			cin >> arr[i][j];
	}
	
	int cnt=0, min=987654321;
	
	for(int i=0; i<y-7; i++) {  //W로 시작하는 체스 
		for(int j=0; j<x-7; j++) {
			cnt=0;
			for(int l=0; l<8; l++) {
				if(l%2==0) {						
					for(int k=0; k<8; k+=2) {
						if(arr[i+l][j+k]!='W') cnt++;
					}
					for(int k=1; k<8; k+=2) {
						if(arr[i+l][j+k]!='B') cnt++;
					}
				}
				else {
					for(int k=0; k<8; k+=2) {
						if(arr[i+l][j+k]!='B') cnt++;
					}
					for(int k=1; k<8; k+=2) {
						if(arr[i+l][j+k]!='W') cnt++;
					}
				}
			}
			if(cnt<min) min=cnt;
		}
	}

	for(int i=0; i<y-7; i++) { //B로 시작하는 체스 
		for(int j=0; j<x-7; j++) {
			cnt=0;
			for(int l=0; l<8; l++) {
				if(l%2==0) {						
					for(int k=0; k<8; k+=2) {
						if(arr[i+l][j+k]!='B') cnt++;
					}
					for(int k=1; k<8; k+=2) {
						if(arr[i+l][j+k]!='W') cnt++;
					}
				}
				else {
					for(int k=0; k<8; k+=2) {
						if(arr[i+l][j+k]!='W') cnt++;
					}
					for(int k=1; k<8; k+=2) {
						if(arr[i+l][j+k]!='B') cnt++;
					}
				}
			}
			if(cnt<min) min=cnt;
		}
	}
	
	cout << min;
}





또는 




#include <bits/stdc++.h>
using namespace std;

string blackBoard[] = {
	{"BWBWBWBW"},
	{"WBWBWBWB"},
	{"BWBWBWBW"},
	{"WBWBWBWB"},	
	{"BWBWBWBW"},
	{"WBWBWBWB"},	
	{"BWBWBWBW"},
	{"WBWBWBWB"},
};

string whiteBoard[] = {
	{"WBWBWBWB"},
	{"BWBWBWBW"},
	{"WBWBWBWB"},
	{"BWBWBWBW"},	
	{"WBWBWBWB"},
	{"BWBWBWBW"},
	{"WBWBWBWB"},
	{"BWBWBWBW"},	
};

string arr[50];
int mn=987654321;

int bl(int y, int x) {
	int cnt=0;
	for(int i=0; i<8; i++) {
		for(int j=0; j<8; j++) {
			if(blackBoard[i][j]!=arr[i+y][j+x]) cnt++;
		}
	}
	
	return cnt;
}

int wh(int y, int x) {
	int cnt=0;
	for(int i=0; i<8; i++) {
		for(int j=0; j<8; j++) {
			if(whiteBoard[i][j]!=arr[i+y][j+x]) cnt++;
		}
	}
	
	return cnt;
}

int main() {
	int n, m, ans=987654321;
	cin >> n >> m;
	for(int i=0; i<n; i++) {
		cin >> arr[i];
	}
	
	for(int i=0; i<n-7; i++) {
		for(int j=0; j<m-7; j++) {
			ans = min(ans,min(bl(i,j), wh(i,j)));
		}
	}
	cout << ans;
} 
