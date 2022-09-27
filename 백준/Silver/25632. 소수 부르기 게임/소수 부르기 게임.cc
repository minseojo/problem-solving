#include <bits/stdc++.h>
using namespace std;

int num[1001];
vector<int> t;
vector<int> s;
int main() {
    int a, b, c, d;
    cin >> a >> b >> c >> d;
  num[1] =-1;
    for(int i=2; i<1001; i++) {
      for(int j=i+i; j<1001; j+=i) {
        num[j] = -1;
      }
    }
    for(int i=a; i<=b; i++) {
      if(num[i]!=-1) {
        t.push_back(i);
      }
    }
    for(int i=c; i<=d; i++) {
      if(num[i]!=-1) {
       s.push_back(i);
      }
    }
  int cnt=0;
  for(int i=0; i<t.size(); i++) {
    for(int j=0; j<s.size(); j++) {
      if(t[i]==s[j]) {
        cnt++;
        break;
      }
    }
  }
  int cntT = t.size()-cnt;
  int cntS = s.size()-cnt;
  if(cnt%2==0) {
    if(cntT>cntS) cout << "yt";
    else cout<< "yj";
  } else{
    if(cntT>=cntS) cout << "yt";
    else cout<< "yj";
  }
  
  return 0;
}