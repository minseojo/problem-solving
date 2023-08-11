// multiset 이용 
#include <bits/stdc++.h>
using namespace std;

vector<int> v;

int main() {
	int n, x;
	scanf("%d", &n);
	multiset<int> s;
	while(n--) {
		scanf("%d", &x);
		if(x!=0) s.insert(x);
		else {
			if(s.empty()) v.push_back(0);
			else {
				auto end=s.end();
				end--;
				v.push_back(*end);
				s.erase(end);
			}
		}
	}
	for(int i=0; i<v.size(); i++)
		printf("%d\n", v.at(i));
		
	return 0;
}

/* priority_queue이용 (우선순위큐) 
#include <bits/stdc++.h>
using namespace std;

vector<int> v;

int main() {
	int n, x;
	scanf("%d", &n);
	priority_queue<int> pq;
	while(n--) {
		scanf("%d", &x);
		if(x!=0) pq.push(x);
		else {
			if(pq.empty()) v.push_back(0);
			else {
				v.push_back(pq.top());
				pq.pop();
			}
		}
	}
	for(int i=0; i<v.size(); i++)
		printf("%d\n", v.at(i));
		
	return 0;
}
*/

