#include<vector>
#include<queue>
#include<iostream>
using namespace std;
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};
vector<vector<int>> dist;
bool visited[104][104];
int solution(vector<vector<int>> maps)
{
    int answer = 0;
    int max_x = maps[0].size();
    int max_y = maps.size();
    dist.assign(max_y, vector<int>(max_x, 0));
    dist[0][0] = 1; // 추가 된 코드
    queue<pair<int,int>> q;
    q.push({0,0});  // 처음 시작점 (1,1)
    while(!q.empty()){
        auto cur_location = q.front();
        q.pop();
        int x = cur_location.second;
        int y = cur_location.first;
        visited[y][x] = true;
        if(x == max_x-1 && y == max_y-1){
            return dist[y][x];
        }
        for(int i = 0; i < 4; i++){
if(x+dx[i] < 0 || y+dy[i] < 0 || x+dx[i] >= max_x ||y+dy[i] >= max_y||maps[y+dy[i]][x+dx[i]] == 0 || visited[y+dy[i]][x+dx[i]]==true ) continue;
            visited[y+dy[i]][x+dx[i]] = true;
            q.push({y+dy[i], x+dx[i]});
            dist[y+dy[i]][x+dx[i]] = dist[y][x]+1;
        }
    }
     if(dist[max_x-1][max_y-1] == 0)
         return -1;
    return answer;
}