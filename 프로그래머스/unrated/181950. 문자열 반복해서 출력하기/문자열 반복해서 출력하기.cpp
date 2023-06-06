#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    int n;
    cin >> str >> n;
    for(int step = 0; step < n; step++) {
        cout << str;
    }
    return 0;
}