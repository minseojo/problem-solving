#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<string> stringSplit(string s) {
    vector<string> result;
    string str = "";
    for (int i = 0; i < s.length(); i++) {
        str += s[i];
        if (s[i] == ' ') {
            result.push_back(str);
            str = "";
        }
    }
    if (str != "") result.push_back(str);
    
    return result;
}

string solution(string s) {
    string answer = "";
    vector<string> strings;
    strings = stringSplit(s);
    for (string str : strings) {
        if ('a' <= str[0] && str[0] <= 'z') str[0] -= 32;
        for (int i =  1; i < str.length(); i++) {
            if ('A' <= str[i] && str[i] <= 'Z') str[i] += 32;
        }
        answer += str;
    }

    return answer;
}