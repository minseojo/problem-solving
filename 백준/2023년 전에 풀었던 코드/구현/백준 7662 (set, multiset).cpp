/*
set과 multiset의 차이점:
set은 중복x
multiset은 중복O 
*/


#include <bits/stdc++.h>
using namespace std;

int main() {
	int tc;
	cin >> tc;

	while(tc--) {
		multiset<int> s;
		int n, x;
		char c;
		cin >> n;
		for(int i=0; i<n; i++) {
			cin >> c >> x;
			
			if(c=='I') {
				s.insert(x);
			} else {
				if(s.empty()) continue;
				else if(x==1) {
					auto iter = s.end();
					iter--;
					s.erase(iter);
				} else {
					auto iter = s.begin();
					s.erase(iter);
				}
			}
		}
		if(!s.empty()) {
			auto end=s.end();
			end--;
			cout << *end << " " << *s.begin() << endl;
		}
		else cout <<"EMPTY" << endl;
	}
} 
