# include <bits/stdc++.h>
using namespace std;

int n = 10;
int input[10][10];
int cache[10][10];

bool isValidRange(int y, int x) {
    if (y < 0 || x < 0 || y >= n || x >= n) return false;
    return true;
}

bool check() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (cache[i][j] != input[i][j]) return false;
        }
    }
    return true;
}

bool go0(int y, int x, int size) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < i+1; j++) {
            int ny = y + i;
            int nx = x + j;
            if (!isValidRange(ny, nx)) return false;
            cache[ny][nx] = 1;
        }
    }
    return true;
}

bool go1(int y, int x, int size) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size-i; j++) {
            int ny = i + y;
            int nx = j + x;
            if (!isValidRange(ny, nx)) return false;
            cache[ny][nx] = 1;
        }
    }
    return true;
}

bool go2(int y, int x, int size) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < i+1; j++) {
            int ny = y + i;
            int nx = x - j;
            if (!isValidRange(ny, nx)) return false;
            cache[ny][nx] = 1;
        }
    }

    return true;
}

bool go3(int y, int x, int size) {
    for (int i = 0; i < size; i++) {
        for (int j = i; j < size; j++) {
            int ny = y + i;
            int nx = x + j;
            if (!isValidRange(ny, nx)) return false;
            cache[ny][nx] = 1;
        }
    }
    return true;
}

bool go4(int y, int x, int size) {
    return (1 & size) && go0(y-size/2, x, size/2+1) && go1(y, x, size/2+1);
}

bool go5(int y, int x, int size) {
    return (1 & size) && go3(y, x-size/2, size/2+1) && go1(y, x, size/2+1);
}
bool go6(int y, int x, int size) {
    return (1 & size) && go2(y-size/2, x+size/2, size/2+1) && go3(y, x, size/2+1);
}
bool go7(int y, int x, int size) {
    return (1 & size) && go2(y, x, size/2+1) && go0(y, x, size/2+1);
}

bool(*go[8])(int, int, int) = {go0, go1, go2, go3, go4, go5, go6, go7};

struct Point {
    int y;
    int x;
};
vector<Point> ans;

bool comp(Point &a, Point &b) {
    if (a.y == b.y) return a.x < b.x;
    return a.y < b.y;
}

void getAns(int type, int y, int x, int size) {
    size = size-1;
    switch (type)
    {
    case 0:
        ans.push_back({y, x});
        ans.push_back({y+size, x});
        ans.push_back({y+size, x+size});
        break;
    case 1:
        ans.push_back({y, x});
        ans.push_back({y, x+size});
        ans.push_back({y+size, x});
        break;
    case 2:
        ans.push_back({y, x});
        ans.push_back({y+size, x});
        ans.push_back({y+size, x-size});
        break;
    case 3:
        ans.push_back({y, x});
        ans.push_back({y, x+size});
        ans.push_back({y+size, x+size});
        break;
    case 4:
        ans.push_back({y-size/2, x});
        ans.push_back({y+size/2, x});
        ans.push_back({y, x+size/2});
        break;
    case 5:
        ans.push_back({y, x-size/2});
        ans.push_back({y, x+size/2});
        ans.push_back({y+size/2, x});
        break;
    case 6:
        ans.push_back({y, x});
        ans.push_back({y-size/2, x+size/2});
        ans.push_back({y+size/2, x+size/2});
        break;
    case 7:
        ans.push_back({y, x});
        ans.push_back({y+size/2, x-size/2});
        ans.push_back({y+size/2, x+size/2});
        break;
    default:
        break;
    }

    sort(ans.begin(), ans.end(), comp);
}

int main() {
    for (int i = 0; i < 10; i++) {
        string str;
        cin >> str;
        for (int j = 0; j < str.length(); j++) {
            input[i][j] = str[j]-'0';
        }
    }

    for (int type = 0; type < 8; type++ ){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 2; k <= n; k++) {
                    memset(cache, 0, sizeof(cache));
                    if(go[type](i, j, k) && check()) {
                        getAns(type, i, j, k);
                        if (ans.size() > 0) {
                            for (Point answer : ans) {
                                cout << answer.y+1 << " " << answer.x+1 << endl;
                            }
                        } 
                        return 0;
                    }
                }
            }
        }
    }

    cout << 0;
    return 0;
}