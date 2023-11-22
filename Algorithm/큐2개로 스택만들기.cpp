#include <bits/stdc++.h>
using namespace std;

int n;
queue<int> sub_queue; 
queue<int> main_queue;
vector<int> answer;

void input() {
	cin >> n;
	for(int i=0; i<n; i++) {
		int num;
		cin >> num;
		sub_queue.push(num);
	}
}

void solve() {
	while(1) {
		//종료문 
		if(answer.size()==n) break;

		//서브큐에 있는거 메인큐로 옮기기
		while(!sub_queue.empty()) {
			main_queue.push(sub_queue.front());
			sub_queue.pop();
		}
		
		// 메인에 1개만 남겨놓고 다시 서브큐에 넣기 
		while(main_queue.size()!=1) {
			sub_queue.push(main_queue.front());
			main_queue.pop();
		}
		
		// 메인큐에 남은거 1개 다른 저장소에 보관해놓기
		int front = main_queue.front();
		answer.push_back(front);
		main_queue.pop();
	}	
} 
void print() {
	//출력 
	for(auto it : answer) {
		cout << it << " ";
	}	
}
int main() {	
	input();
	solve();
	print();
	return 0; 
}
