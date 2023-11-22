#include <bits/stdc++.h>
using namespace std;

int main() {
    while(1) {
        string s;
        getline(cin, s);
        if (s == "#") break;
        stack<string> stack;
        string tag = "";
        bool tag_s = false;
        for (int i = 0; i < s.size(); i++) {
            char c = s[i];
            if (c == '<') {
                tag_s = true;
            }

            else if (tag_s && c == '>') {
                if (tag == "br /") {
                    tag = "";
                    tag_s = false;
                   continue; 
                }
                if (tag[0] == '/') {
                    string stag = "";
                    tag = tag.substr(1, tag.size()-1);
                    if (!stack.empty()) stag = stack.top().substr(0, tag.size());
                    if (stag == tag) stack.pop();
                    else stack.push("/" + tag);
                }
                else {
                    stack.push(tag);
                }
                tag = "";
                tag_s = false;
            } 
            else if (tag_s && c != '>') {
                tag += c;
            }
        }

        if (stack.empty()) cout << "legal" << endl;
        else cout << "illegal" << endl;
    }
    return 0;
}