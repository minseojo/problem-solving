#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

void solution(int n, int start, int temp, int end) {
    if(n == 1) cout << start << ' ' << end << endl;
    else {
        solution(n-1, start, end, temp);
		cout << start << ' ' << end << endl;
        solution(n-1, temp, start, end);
    }
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N, sum;
	cin >> N;
	sum = pow(2, N) - 1;
	
	cout << sum << endl;
	solution(N, 1, 2, 3);
	
	return 0;
}