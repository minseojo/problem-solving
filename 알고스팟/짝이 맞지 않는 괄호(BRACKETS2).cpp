#include <bits/stdc++.h>
using namespace std;

bool solve(const string& formula) {
	const string opening("({["), closing(")}]");
	stack<char> openStack;
	for(int i=0; i<formula.size(); i++) {
		if(opening.find(formula[i]) != -1)
			//여는 괄호라면 무조건 스택에 집어 넣는다. 
			openStack.push(formula[i]);

		else {
			//스택이 비어 있는경우에는 실패 
			if(openStack.empty()) return false;
			//서로 짝이 맞지 않으면 실패 
			if(opening.find(openStack.top()) != closing.find(formula[i]))
				return false;
			//짝을 맞춘 괄호는 스택에서 뺀다.
			openStack.pop();
		} 
		// 닫히지 않은 괄호가 없어야 성공
	}
	return openStack.empty();
}

int main() {
	int tc;
	cin >> tc;
	while(tc--) {
		string str="";
		cin >> str;
		if(solve(str)) cout << "YES" << endl;
		else cout << "NO" << endl;
	}
	
	return 0;
} 
