#include <bits/stdc++.h>
using namespace std;

struct St {
	int id;
	long long product;
	int sum;
} ranking[101];


bool comp(St a, St b) {
	if(a.product != b.product) return a.product > b.product; // 오름차순
	else {
		if(a.sum != b.sum) return a.sum > b.sum; // 오름차순 
		else {
			return a.id > b.id; // 오름차순 
		}
	}
}

int main() {
	int n;
	cin >> n;
	for(int i=0; i<n; i++) {
		int id, a, b, c;
		cin >> id >> a >> b >> c;
		ranking[i].id = id;
		ranking[i].product = a*b*c;
		ranking[i].sum = a+b+c;
	}
	sort(ranking, ranking+n, comp);
	cout << ranking[n-1].id << " " << ranking[n-2].id << " " << ranking[n-3].id;
}