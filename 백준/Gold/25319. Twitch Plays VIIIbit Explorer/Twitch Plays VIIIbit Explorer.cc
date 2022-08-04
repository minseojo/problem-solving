#include <bits/stdc++.h>
using namespace std;

struct st {
	int y;
	int x;
};

int n, m;
string id;
char board[51][51];
int dy[4] = {-1,1,0,0};
int dx[4] = {0,0,-1,1};
int alpha[26]; // 보드에 나온 알파벳 개수 
int id_alpha[26]; // 아이디에 나오는 알파벳 개수 
vector<int> id_position[26]; // 각 알파벳에 따른 알파벳  위치 좌표
vector<char> player; // player 명령어 모음 ex) UDPDUPUDDP
int y = 0, x = 0;

void init() {
	int id_size;
	cin >> n >> m >> id_size;
	for(int i=0; i<n; i++) {
		string M;
		cin >> M;
		for(int j=0; j<M.size(); j++) {
			board[i][j] = M[j];
		}
	}
	
	cin >> id;
}

int count() {	
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			alpha[board[i][j]-'a'] += 1;
		}
	}
	
	
	for(int i=0; i<id.size(); i++) {
		id_alpha[id[i]-'a'] += 1;
	}
	
	// id와 일치하는 문자 좌표 저장 해놓기 
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			int alpha_cnt = alpha[board[i][j]-'a'];
			if(alpha_cnt > 0) {
				id_position[board[i][j]-'a'].push_back({i*100 + j}); // y * 100, x  도출할떄는 value/100, value%100 
			}
		}
	}
	
	// 최대 강화 횟수 
	int result = 1e9;
	for(int i=0; i<id.size(); i++) {
		result = min(result, alpha[id[i]-'a'] / id_alpha[id[i]-'a']);
	}
	
	return result;
}

void move(int move_y, int move_x) {
	if(move_y > 0) {
		for(int i=0; i<move_y; i++) {
			player.push_back('D');
		}
	}
	else if(move_y < 0) {
		for(int i=0; i<abs(move_y); i++) {
			player.push_back('U');
		}
	}
	
	if(move_x > 0) {
		for(int i=0; i<move_x; i++) {
			player.push_back('R');
		}
	}
	else if(move_x < 0) {
		for(int i=0; i<abs(move_x); i++) {
			player.push_back('L');
		}
	}
	
	y += move_y;
	x += move_x;

}

void solution(int c) {
	int pos = 0; // 먹은아이템과 일치하는 id 현재 위치 ( 0 ~ id.size()-1)	
	int result = c;// 정답 기억해놓기 (필요없는 변수)
	int id_size = id.size(); 
	while(c--) {
		pos = 0;
		for(int id_size = 0; id_size<id.size(); id_size++) {
			// id[pos] = "ucpc"
			// if(pos == id.size()) pos = 0;
			// 찾을 문자 
			char find_alpha = id[pos];
			
			//찾을 문자 좌표개수 (있는 여부 판별) 
			int size = id_position[find_alpha-'a'].size();
			if(size > 0) {
				// 찾을 문자 좌표 (y, x) 
				int find_y = id_position[find_alpha-'a'][size-1]/100;
				int find_x = id_position[find_alpha-'a'][size-1]%100;
			
				// 여기서 찾을 문자까지 움직여야 할 좌표 => 목적지 - 현재 
				int move_y = find_y - y;
				int move_x = find_x - x;
				
				move(move_y, move_x);
				player.push_back('P');
				id_position[find_alpha-'a'].erase(id_position[find_alpha-'a'].end()-1); // 먹은 좌표 삭제
				pos += 1;
				if(pos == id.size()) pos = 0;
			}
		}
	}
	int move_y = n-1 - y;
	int move_x = m-1 - x;				
	move(move_y, move_x);
	
	cout << result << " " << player.size() << '\n';
	for(int i=0; i<player.size(); i++) {
		cout << player[i];
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	init();
	int c = count();
	solution(c);
	
	return 0;
}