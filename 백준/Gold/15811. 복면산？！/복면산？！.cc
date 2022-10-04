#include <bits/stdc++.h>
using namespace std;

string words[3];
string s;
int alpha[26];
bool visited[10];
bool ok;

void dfs(int pos) {
	if(ok) return;
    if(pos == s.size()) {
        int nums[3] = {0, 0, 0};
        for(int i=0; i<3; i++){
            for(int j=0; j<words[i].size(); j++){
                nums[i] *= 10;
                nums[i] += alpha[words[i][j] - 'A'];
            }
        }

        if(nums[0] + nums[1] == nums[2]) ok = true; 
        return;
    }

  	for(int i=0; i<10; i++) {
  		if(visited[i]) continue;
  		visited[i] = true;
  		alpha[s[pos]-'A'] = i;
  	  	dfs(pos+1);
  	  	visited[i]=false;
 	}
}

int main() {	
	ios_base::sync_with_stdio(false);	
	cin.tie(NULL);
	cout.tie(NULL);
	
  	cin >> words[0] >> words[1] >> words[2];
    for(int i=0; i<3; i++) {
    	for(int j=0; j<words[i].size(); j++) {
    		alpha[words[i][j]-'A'] = 1;
		}
	}

	for(int i=0; i<26; i++) {
    	if(alpha[i]) s.push_back('A'+i);
  	}
  	dfs(0);	
  	if(ok) cout << "YES";
  	else cout << "NO";
  	return 0;
}