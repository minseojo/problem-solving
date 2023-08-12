#include <string>
#include <vector>
#include <iostream>
#include <math.h>
using namespace std;

int ans[2] = {1000000000, -1000000000};
string solution(string s) {
    string str = "";
    
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == ' ') {
            int number = stoi(str);
            ans[0] = min(ans[0], number);
            ans[1] = max(ans[1], number);
            str = "";
        } else {
            str += s[i];
        }
    }
    int number = stoi(str);
    ans[0] = min(ans[0], number);
    ans[1] = max(ans[1], number);
    return to_string(ans[0]) + " " + to_string(ans[1]);
}