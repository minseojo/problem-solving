#include <bits/stdc++.h>
#define MAX 100001
using namespace std;

struct Item {
	int cost;
	int value;
};

vector<Item> item;
int C, N;
int dp[MAX];

int main() {
	cin >> C >> N;
	
	int cost, value;
	for(int i=0; i<N; i++) {
		cin >> cost >> value;
		item.push_back({cost, value});
	}
	
	for(int i=0; i<item.size(); i++) {
		for(int j=item[i].cost; j<=MAX; j++) {
			dp[j] = max(dp[j], dp[j - item[i].cost] + item[i].value);
		}
	}
	
	for(int i=1; i<=MAX; i++) {
		if(dp[i] >= C) {
			cout << i;
			break;
		}
	}
    
    return 0;
}