#include <string>
#include <vector>
#include <iostream>
#include <queue>
using namespace std;
// 현재 y, 현재 x, 현재 dir, 현재 cost, 
// 큐에 처음에 4방향에 대해 넣어놓고, 다음 방향에따라 600 || 100 정함, - 커브 시500+100= 600
// 방향은 북동남서 북,남 에서 동,서로 가면 600, 동,서에서 북,남으로 가면 600
// else 100
struct st {
    int y;
    int x;
    int dir; // dir%4 = {0,1,2,3} 북동남서
    int cost;
};

struct cmp {
    // cost 오름차순 (비용 작은거부터 탐색)
    bool operator()(const st &a, const st &b) {
        return a.cost > b.cost;
    }
};

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1}; //북동남서
priority_queue<st, vector<st>, cmp> pq;
bool visited[25][25][4]; // y x dir

int bfs(vector<vector<int>> board) {
    // y x dir cost 북동남서 넣기
    pq.push({0, 0, 0, 0}); visited[0][0][0] = true;
    pq.push({0, 0, 1, 0}); visited[0][0][1] = true;
    pq.push({0, 0, 2, 0}); visited[0][0][2] = true;
    pq.push({0, 0, 3, 0}); visited[0][0][3] = true;
    int column = board.size();
    int row = board.at(0).size();
    while(!pq.empty()) {
        int y = pq.top().y;
        int x = pq.top().x;
        int dir = pq.top().dir;
        int cost = pq.top().cost;
        visited[y][x][dir] = true;
        pq.pop();
        if(y==column-1 && x==row-1) return cost;
        // 북 동 남 서
        //  0 1 2 3
        for(int i=0; i<4; i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny<0 || nx<0 || ny>column-1 || nx>row-1) continue;
            if(board.at(ny).at(nx) == 1) continue;
            if(visited[ny][nx][dir]) continue;
            //북
            if(dir==0) {
                if(dy[i]==-1) pq.push({ny, nx, i, cost+100});
                else if(dy[i]==1) continue;
                else pq.push({ny, nx, i, cost+600});
            }
            //남
            else if(dir==2) {
                if(dy[i]==1) pq.push({ny, nx, i, cost+100});
                else if(dy[i]==-1) continue;
                else pq.push({ny, nx, i, cost+600});
            }
            //동
            if(dir==1) {
                if(dx[i]==1) pq.push({ny, nx, i, cost+100});
                else if(dx[i]==-1) continue;
                else pq.push({ny, nx, i, cost+600});
            }
            //서
            else if(dir==3) {
                if(dx[i]==-1) pq.push({ny, nx, i, cost+100});
                else if(dx[i]==1) continue;
                else pq.push({ny, nx, i, cost+600});
            }
        }
    }
    return -1; //도달 못함
}
int solution(vector<vector<int>> board) {
    int answer = 0;
    answer = bfs(board);
    return answer;
}

