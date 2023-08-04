#include <bits/stdc++.h>
using namespace std;

const int WIN = 0;
const int DRAW = 1;
const int LOSE = 2;

struct Match {
    int teamA;
    int teamB;
};


const static int TOTAL_TEAM_COUNT = 6;
const static int TOTAL_MATCH_COUNT = 15;
vector<Match> matches = {
    {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
    {1, 2}, {1, 3}, {1, 4}, {1, 5},
    {2, 3}, {2, 4}, {2, 5},
    {3, 4}, {3, 5},
    {4, 5}
};

int record[TOTAL_MATCH_COUNT][3];
int cache[TOTAL_MATCH_COUNT][3];

bool dfs(int matchCount) {
    if (matchCount == TOTAL_MATCH_COUNT) {
        for (int i = 0; i < TOTAL_TEAM_COUNT; i++) {
            for (int j = 0; j < 3; j++) {
                if (cache[i][j] != record[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    int teamA = matches[matchCount].teamA;
    int teamB = matches[matchCount].teamB;
    // teamA, teamB
    // win, lose
    cache[teamA][WIN]++;
    cache[teamB][LOSE]++;
    if (dfs(matchCount+1)) return true;
    cache[teamA][WIN]--;
    cache[teamB][LOSE]--;

    // draw, draw
    cache[teamA][DRAW]++;
    cache[teamB][DRAW]++;
    if (dfs(matchCount+1)) return true;
    cache[teamA][DRAW]--;
    cache[teamB][DRAW]--;

    // lose, win
    cache[teamA][LOSE]++;
    cache[teamB][WIN]++;
    if (dfs(matchCount+1)) return true;
    cache[teamA][LOSE]--;
    cache[teamB][WIN]--;

    return false;
}

vector<int> ans;
int main() {
    int tc = 4;
    while(tc--) {
        memset(cache, 0, sizeof(cache));
        for (int i = 0; i < TOTAL_TEAM_COUNT; i++) {
            for (int j = 0; j < 3; j++) {
                cin >> record[i][j];
            }
        }
        ans.push_back(dfs(0));
    }

    for (int answer : ans) {
        cout << answer << " ";
    }
}