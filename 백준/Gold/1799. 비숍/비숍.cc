#include <iostream>
#define MAX 10
 
using namespace std;
 
bool chess[MAX][MAX];
bool visited1[MAX * 2]; //오른쪽에서 왼쪽으로 가는 대각선
bool visited2[MAX * 2]; //왼쪽에서 오른쪽으로 가는 대각선
int bishop[2];
int chess_size;
 
//for문없이 재귀함수만으로 구현하기
// color == 0 : 검은색, color == 1 : 흰색
void DFS(int cnt, int x, int y, int color) {
    if (x >= chess_size) {
        y++;
        if (x % 2 == 0) x = 1;
        else x = 0;
    }
    if (y >= chess_size) {
        bishop[color] = max(bishop[color], cnt);
        return;
    }
 
    if (chess[y][x] && !visited1[x + y + 1] && !visited2[x - y + chess_size]) {
        visited1[x + y + 1] = true;
        visited2[x - y + chess_size] = true;
        DFS(cnt + 1, x + 2, y, color);
        visited1[x + y + 1] = false;
        visited2[x - y + chess_size] = false;
    }
    DFS(cnt, x + 2, y, color);
}
 
int main(void) {
    cin >> chess_size;
 
    for (int i = 0; i < chess_size; i++)
        for (int j = 0; j < chess_size; j++)
            cin >> chess[i][j];
    
    DFS(0, 0, 0, 0); //검은색 체스판
    DFS(0, 1, 0, 1); //흰색 체스판
 
    cout << bishop[0] + bishop[1] << '\n';
    return 0;
}