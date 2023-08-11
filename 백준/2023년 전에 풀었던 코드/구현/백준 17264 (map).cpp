#include <bits/stdc++.h>
using namespace std;

map<string, int> List;

int main() {
    
    ios_base::sync_with_stdio(false);	
    cin.tie(NULL);
    cout.tie(NULL);
    
	int n, p;
	cin >> n >> p;
	int win, lose, goal=0;
	cin >> win >> lose >> goal;
	
	lose=lose*-1;
	string man, game;
	int x=0;
	for(int i=0; i<p; i++) {
		cin >> man >> game;
		if(game=="W") x=win;
		else x=lose;
		List[man]=x;
	}
	
	int sum=0, flag=0;
	for(int i=0; i<n; i++) {
		cin >> man;
		if(sum>=goal) flag=1;
		if(List[man]) {
			sum+=List[man];
			if(sum<0) sum=0;
		} else {
			sum+=lose;
			if(sum<0) sum=0;
		}
	}
	
	if(flag) cout << "I AM NOT IRONMAN!!";
	else cout << "I AM IRONMAN!!";
    
    return 0;
}
