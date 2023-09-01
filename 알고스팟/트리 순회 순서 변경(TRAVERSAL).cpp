#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> slices(const vector<int>& v, int a, int b) {
	return vector<int>(v.begin() + a, v.begin() + b);
}

void solve(const vector<int>& preod,const  vector<int>& inod) {
	int size=preod.size(); // ¶Ç´Â in.size();
	if(size==0) return; 
	
	int root=preod[0];
	
	int L= find(inod.begin(), inod.end(), root) - inod.begin();
	solve(slices(preod, 1, L+1), slices(inod, 0, L));
	solve(slices(preod, L+1, size), slices(inod, L+1, size));
	cout << root << " ";
	return;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int tc;
	cin >> tc;
	while(tc--) {
		int n;
		cin >> n;
		int num;
		vector<int> preOrder(n), inOrder(n);
		for(int i=0; i<n; i++) {
			cin >> preOrder[i];
		}  
		for(int i=0; i<n; i++) {
			cin >> inOrder[i];
		}
		solve(preOrder, inOrder);
		cout << "\n";
	}
	
	return 0;
} 
