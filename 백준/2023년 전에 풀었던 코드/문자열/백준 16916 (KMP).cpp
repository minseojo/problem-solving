#include <bits/stdc++.h>
using namespace std;

string t, p, p2;
vector<int> pi(1000000);
vector<int> answer;

void preprocessing() {
	int i=1, k=0;
	pi[1]=0;
	while(i<=p.size()) {
		if(k==0 || p[i]==p[k]) {i++; k++; pi[i]=k; }
		else k=pi[k];
	}
}

void kmp() {
	preprocessing();
	int i=0, j=1;
	int n=t.size(), m=p.size()-1; // -1하는이유는 p 맨앞에 공백을 추가함 
	while(i<=n) {
		if(j==0 || t[i]==p[j]) {i++; j++;}
		else j=pi[j];
		cout << j << " ";
		if(j==m+1) {
			answer.push_back(i-m+1);
			j=pi[j];
		}
	}
}

int main() {
	getline(cin, t);
    getline(cin, p2);
    p+=" ";
    p+=p2;
    kmp();

    if(answer.size()>0) cout << 1;
    else cout << 0;
    
    return 0;
}
