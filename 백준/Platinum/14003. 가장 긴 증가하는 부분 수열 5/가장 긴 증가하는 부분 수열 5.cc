#include <bits/stdc++.h>
using namespace std;

vector<int> v;
int a[1000001];
int dp[1000001];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int n, x;
	cin >> n;
	
	int size = 0, cur = -1;	
	for(int i=0; i<n; i++) {
		cin >> x;
        a[i] = x;
		if(i==0) {
			v.push_back(x);
            dp[i] = 1;

		}
		else {
			if(v.back() < x) {
				v.push_back(x);
	            dp[i] = v.size();
			} else if(v.back() >= x){
			   /* auto p = lower_bound(v.begin(),v.end(), x); 
				*(p)=x;
				cout << v.back() << " " << x << " " << p-v.begin()+1 << endl;
                dp[i]=p-v.begin()+1;
			*/	auto iter = lower_bound(v.begin(), v.end(), x);
				*(iter) = x;
	            dp[i] = iter-v.begin()+1;
	        
			}	
		}
		if(dp[i] > size) {
			size = dp[i];
			cur = i;
		}
	//	cout << dp[i] << " ";
	}//cout << endl;

	cout << size << endl;
    
    for(int i=0; i<n; i++) {
        if(dp[i] == size) {
            cur = i;
        }
    }
    stack<int> result;
    result.push(a[cur]);

  // for(int i=0; i<n; i++) cout << dp[i] << " ";
	//cout << endl;
	int pre = cur;
	for(int i=cur-1; i>=0; i--) {
        if(dp[i]+1 == dp[pre] && a[i] < a[pre]) {
            result.push(a[i]);
            pre = i;
            //cout << pre << " " << a[i] << endl;
        }
       // if(i==0) cout << a[i] << " " << a[pre];
    }
    while(!result.empty()) {
        cout << result.top() << " ";
        result.pop();
    }
}