#include <bits/stdc++.h>
using namespace std;

int N;
int A[1001];
int DP[1001];
int pre[1001];

void init() {
	cin >> N;
	for(int i = 0; i < N; i++) {
		cin >> A[i];
		DP[i] = 1;
	}	
}

void solve() {
	int size = 0, cur = -1;
	
	for (int i = 0; i < N; i++) {
        pre[i] = -1;
		for (int j = 0; j < i; j++) {
			if(A[i] > A[j] && DP[i] < DP[j]+1) {
				DP[i] = DP[j] + 1;
                pre[i] = j;
                
			}
		}
		if(DP[i] > size) {
			size = DP[i];
			cur = i;
		}
	}
	
	cout << size << endl;
	
    vector<int> answer;
    answer.push_back(A[cur]);
    
    int pre = cur;
    for(int i=cur-1; i>=0; i--) {
    	if(DP[i]+1 == DP[pre] && A[i] < A[pre]) {
    		answer.push_back(A[i]);
    		pre = i;
		}
	}
    
    reverse(answer.begin(), answer.end());
    for(int i : answer) {
        cout << i << " ";
    }

}

int main() {
	init();
	solve();
	
	return 0;
}