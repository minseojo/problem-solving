#include <bits/stdc++.h>
using namespace std;

string s;
int len;
int alpha[26];
char cache[26];

void dfs(int pos) {
  if(pos==len) {
    for(int i=0; i<s.size(); i++) cout << cache[i];
    cout << "\n";
    return;
  }

  for(int i=0; i<26; i++) {
    if(alpha[i] == 0) continue;
    alpha[i]--;
    cache[pos] = 'a' + i;
    dfs(pos+1);
    alpha[i]++;
  }
}

int main() {
  int tc;
  cin >> tc;
  while(tc--) {
    cin >> s;
    len = s.size();
    memset(alpha, 0, sizeof(alpha));
    for(int i=0; i<len; i++) {
      alpha[s[i]-'a']++;
    }
    dfs(0);
  }
}