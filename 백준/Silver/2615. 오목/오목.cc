#include <bits/stdc++.h>
using namespace std;

int a[20][20];

struct Point {
	int y;
	int x;
};

int left(int sy, int sx, int color) {
	int ret = 0;
	for (int x = sx-1; x > sx-6; x--) {
		if (x < 0 || x >= 19) break;
		if (a[sy][x] != color) {
			break;
		}
		ret++;
	}
	return ret;
}

int right(int sy, int sx, int color) {
	int ret = 0;
	for (int x = sx+1; x <= sx+6; x++) {
		if (x < 0 || x >= 19) continue;
		if (a[sy][x] != color) break;
		ret++;
	}
	return ret;
}

int up(int sy, int sx, int color) {
	int ret = 0;
	for (int y = sy-1; y > sy-6; y--) {
		if (y < 0 || y >= 19) break;
		if (a[y][sx] != color) {
			break;
		}
		ret++;
	}
	return ret;	
}

int down(int sy, int sx, int color) {
	int ret = 0;
	for (int y = sy+1; y <= sy+10; y++) {
		if (y < 0 || y >= 19) {
			break;
		}
		if (a[y][sx] != color) break;
		ret++;
	}
	return ret;	
}

int leftUp(int y, int x, int color) {
	int ret = 0;
	for (int i = 0; i < 10; i++) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19) break;
		y--;
		x--;
		if (a[y][x] != color) break;
		ret++;
	}
	return ret;	
}

int leftDown(int y, int x, int color) {
	int ret = 0;
	for (int i = 0; i < 10; i++) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19) break;
		y++;
		x--;
		if (a[y][x] != color) break;
		ret++;
	}
	return ret;	
}

int rightUp(int y, int x, int color) {
	int ret = 0;
	for (int i = 0; i < 10; i++) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19) break;
		y--;
		x++;
		if (a[y][x] != color) break;
		ret++;
	}
	return ret;	
}

int rightDown(int y, int x, int color) {
	int ret = 0;
	for (int i = 0; i < 10; i++) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19) break;
		y++;
		x++;
		if (a[y][x] != color) break;
		ret++;
	}
	return ret;	
}

bool comp(const Point a, const Point b) {
	if (a.x == b.x) {
		return a.y < b.y;
	}
	return a.x < b.x;
}

vector<Point> ans;
int cnt[8];
int cnt2[8];
int main() {
	for (int i = 0; i < 19; i++) {
		for (int j = 0; j < 19; j++) {
			cin >> a[i][j];
		}
	}
	
	bool isBlack = false;
	for (int i = 0; i < 19; i++) {
		for (int j = 0; j < 19; j++) {
			if (a[i][j] == 1){
				cnt[0] = left(i, j, 1);
				cnt[1] = right(i, j, 1);
				cnt[2] = up(i, j, 1);
				cnt[3] = down(i, j, 1);
				cnt[4] = leftUp(i, j, 1);
				cnt[5] = leftDown(i, j, 1);
				cnt[6] = rightUp(i, j, 1);
				cnt[7] = rightDown(i, j, 1);
				
				if ((cnt[0] + cnt[1]) == 4) {
					isBlack = true;
					ans.push_back({i, j});		
				}
				if ((cnt[2] + cnt[3]) == 4) {
					isBlack = true;
					ans.push_back({i, j});							
				}
				if ((cnt[4] + cnt[7]) == 4) {
					isBlack = true;
					ans.push_back({i, j});							
				}
				if ((cnt[5] + cnt[6]) == 4) {
					isBlack = true;
					ans.push_back({i, j});							
				}
			}
			
			if (a[i][j] == 2) {
				cnt2[0] = left(i, j, 2);
				cnt2[1] = right(i, j, 2);
				cnt2[2] = up(i, j, 2);
				cnt2[3] = down(i, j, 2);
				cnt2[4] = leftUp(i, j, 2);
				cnt2[5] = leftDown(i, j, 2);
				cnt2[6] = rightUp(i, j, 2);
				cnt2[7] = rightDown(i, j, 2);
				if (cnt2[0] + cnt2[1] == 4) {
					ans.push_back({i, j});		
				}
				if (cnt2[2] + cnt2[3] == 4) {
					ans.push_back({i, j});							
				}
				if (cnt2[4] + cnt2[7] == 4) {
					ans.push_back({i, j});							
				}
				if (cnt2[5] + cnt2[6] == 4) {
					ans.push_back({i, j});							
				}
			}
		}
	}
	sort(ans.begin(), ans.end(), comp);
	if (ans.empty()) {
		cout << 0;
	} else {
		if (isBlack) {
			cout << 1 << endl;
		} else{
			cout << 2 << endl;
		}
		cout << ans[0].y+1 << " " << ans[0].x+1<< endl;
	}

	return 0;
}