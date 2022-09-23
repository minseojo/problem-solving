#include <bits/stdc++.h>
using namespace std;

int stu[1000];
bool comp(int &a, int &b) {
	return a > b;
}

int main() {
	int N, k;
	cin >> N >> k;
	for(int i=0; i<N; i++) {
		cin >> stu[i];
	}
	sort(stu, stu+N, comp);
	cout << stu[k-1];
	return 0;
}