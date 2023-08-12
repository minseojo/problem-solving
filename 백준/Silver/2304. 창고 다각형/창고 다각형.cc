#include <bits/stdc++.h>
using namespace std;

struct St{
	int idx;
	int height;
	bool operator< (const St& st) {
		return idx < st.idx;
	}
};

vector<St> v;
int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int idx, height;
		cin >> idx >> height;
		v.push_back({idx, height});
	}
	sort(v.begin(), v.end());
	
	int idx = v[0].idx, height = v[0].height, sum = 0;
	for (int i = 1; i < v.size(); i++) {
		if (height <= v[i].height) {
			sum += (height * (v[i].idx - idx));
			idx = v[i].idx;
			height = v[i].height;
		}
	}
	sum += height;

	idx = v[v.size()-1].idx, height = v[v.size()-1].height;
	for (int i = v.size()-1; i >= 0; i--) {
		if (height < v[i].height) {
			sum += (height * (idx - v[i].idx));
			idx = v[i].idx;
			height = v[i].height;
		}
	}
    
	cout << sum;
	return 0;
}