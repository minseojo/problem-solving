#include <string>
#include <vector>
#include <iostream>
#include <math.h>
using namespace std;

int ansMin = 1e9;
int ansMax = -1e9;
void splitString(string s) {
    string str = "";
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == ' ') {
            int number = stoi(str);
            ansMin = min(ansMin, number);
            ansMax = max(ansMax, number);
            str = "";
        } else {
            str += s[i];
        }
    }
    int number = stoi(str);
    ansMin = min(ansMin, number);
    ansMax = max(ansMax, number);
}

string solution(string s) {
    splitString(s);
    return to_string(ansMin) + " " + to_string(ansMax);
}