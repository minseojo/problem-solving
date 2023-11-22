#include <bits/stdc++.h>
#define TYPE 0
#define ATTACK 1
#define HP 2
using namespace std;

long long room[123456][3];

int main() {
    int N, ATK;
    cin >> N >> ATK;
    for (int i = 0; i < N; i++) {
        cin >> room[i][TYPE] >> room[i][ATTACK] >> room[i][HP];
    }

    long long l = 1, r = 1e17;
    long long ans = 1e17;
    while (l <= r) {
        long long m = (l + r) / 2; // 최대 체력
        long long my_hp = m; // 현재 체력
        long long my_atk = ATK; // 현재 공격력

        for (int i = 0; i < N; i++) {
            long long type = room[i][TYPE];
            long long attack = room[i][ATTACK];
            long long hp = room[i][HP];
            if (type == 1) {
                if (hp % my_atk == 0) my_hp -= (((hp / my_atk) - 1) * attack);
                else my_hp -=((hp / my_atk) * attack);
            } else {
                if (my_hp + hp >= m) my_hp = m;
                else my_hp += hp;
                my_atk += attack;
            }
            if (my_hp <= 0) break;
        }
        if (my_hp > 0) {
            ans = min(ans, m);
            r = m - 1;
        } else {
            l = m + 1;
        }
    }
    cout << ans;
}