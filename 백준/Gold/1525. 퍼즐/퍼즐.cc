#include <bits/stdc++.h>
#define MAX 3
using namespace std;

struct Point {
	int index; // [0, 8]
	string str;
};

const string DEST = "123456780";
set<string> visited;
char board[3][3];
int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};
queue<Point> q;

void Check(string cur, int index, int value) {
	char temp = cur[index];
	string next = cur;
	next[index] = next[index + value];
	next[index + value] = temp;
	if (visited.find(next) != visited.end()) return;
	
	visited.insert(next);
	q.push({index + value, next});
}

int BFS() {
	int result = 0;
	while (!q.empty()) {
		int size = q.size();
		while (size--) {
			int index = q.front().index;
			string cur = q.front().str;
			q.pop();
			if (cur == DEST) return result;
			
			if (index - 1 >= 0 && index % 3 != 0) { // left
				Check(cur, index, -1);
			}	
			if (index + 1 < MAX * MAX && (index + 1) % 3 != 0) { // right
				Check(cur, index, 1);
			}
			if (index + 3 < MAX * MAX) Check(cur, index, 3); // down
			if (index - 3 >= 0) Check(cur, index, -3); // up
		}
		result++;
	}
	
	return -1;
}

int main() {
	int start_index = -1;
	string visite = "";
	for (int i = 0; i < MAX; i++) {
		for (int j = 0; j < MAX; j++) {
			cin >> board[i][j];
			if (board[i][j] == '0') {
				start_index = i * MAX + j;
			}
			visite += board[i][j];
		}
	}

	q.push({start_index, visite});
	visited.insert({visite, true});

	int ans = BFS();
	if (ans == -1) cout << -1;
	else cout << ans;
	return 0;
}