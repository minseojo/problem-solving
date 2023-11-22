#include <string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s) {
    bool answer = true;
    stack<char> left;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '(') {
            left.push('(');
        }
        else if (s[i] == ')') {
            if (left.empty()) return false;
            else if (left.top() == '(') left.pop();
        }
    }
    
    if (!left.empty()) return false;
    return true;
}