#include <bits/stdc++.h>
using namespace std;

map<string, int> nameDic;
map<int, string> numberDic;

int main() {
	int N, M;
	cin >> N >> M;
	
	string name;
	for(int i=1; i<=N; i++) {
		cin >> name;
		nameDic[name] = i;
		numberDic[i] = name;
	}
	
	for(int i=0; i<M; i++) {
		cin >> name;
		if(name[0] >= 'A' )	{
			cout << nameDic[name] << endl;
		}
		else if('0' <= name[0] && name[0] <= '9') {
			int index = stoi(name);
			cout << numberDic[index] << endl;
		}
	}

}

