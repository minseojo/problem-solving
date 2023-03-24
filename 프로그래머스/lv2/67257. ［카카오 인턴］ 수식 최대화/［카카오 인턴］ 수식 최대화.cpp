#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;

struct st{
    string number;
    char sign;
};

//*+-
string priority[6] = {
    {"*+-"},
    {"*-+"},
    {"+*-"},
    {"+-*"},
    {"-*+"},
    {"-+*"}
};

vector<st> cases;
vector<char> op;
int check[101];
string end_word;
long long end_word_long;
long long solution(string exp) {
    long long answer = 0;

    string str = "";
    for(int i=0; i<exp.length(); i++) {
        if('0' <= exp[i] && exp[i] <= '9') {
            str += exp[i];
        } else {
            cases.push_back({str, exp[i]});
            str = "";
        }
    }
    cases.push_back({str, 'E'}); //End의 E를 의미
    
    for(int i=0; i<6; i++) {
        long long sum = 0;
        vector<st> case_copy(cases.begin(), cases.end());
        for(int j=0; j<3; j++) {
            for(int k=0; k<case_copy.size()-1; k++) {
                sum = 0;
                st c = case_copy.at(k);
                st ne = case_copy.at(k+1);
            
                long long cur = stol(c.number);
                long long next = stol(ne.number);
                char sign = c.sign;
                if(sign != priority[i][j]) continue;
                
                if(sign == '*') {
                    sum += (cur*next);
                } else if(sign == '+') {
                    sum += (cur+next);
                } else if(sign == '-') {
                    sum += (cur-next);
                }

                string tostring = to_string(sum);
                ne.number = tostring;
                cout << sum << " ";
                case_copy.erase(case_copy.begin()+k);
                case_copy.erase(case_copy.begin()+k);
                case_copy.insert(case_copy.begin()+k, ne);
                k--;
            }
        }
         cout << sum << endl;
        if(sum < 0) sum *= -1;
        answer = max(answer, sum);
        
    }
    for(int i=0; i<cases.size(); i++) {
        //cout << cases.at(i).number << " " << cases.at(i).sign << endl;
    }
    return answer;
}