#include <bits/stdc++.h>
using namespace std;

int n, m;
deque<int> dq;
deque<int> dq2;
deque<int> dq3;
vector<int> v;
int main() {
	int num;
	cin >> n >> m;
	for(int i=1; i<=n; i++) {
		dq.push_back(i);
	}
	
	int answer=0;
	for(int i=0; i<m; i++) {
		cin >> num;
		if(num == dq.front()) {
			dq.pop_front();
		} else {
			int cnt2=0, cnt3=0;
			dq2 = dq;
			dq3 = dq;
			while(1) {
				if(num == dq2.front()) {
					dq2.pop_front();
					break;
				}
				int x = dq2.front();
				dq2.pop_front();
				dq2.push_back(x);
				cnt2++;
			}
			
			while(1) {
				if(num == dq3.front()) {
					dq3.pop_front();
					break;
				}
				int x = dq3.back();
				dq3.pop_back();
				dq3.push_front(x);
				cnt3++;
			}
			
			if(cnt2 >= cnt3) {
				answer+=cnt3;
				dq = dq3;
			} else {
				answer+=cnt2;
				dq = dq2;
			}
		}
	}
	cout << answer;
	return 0;
}