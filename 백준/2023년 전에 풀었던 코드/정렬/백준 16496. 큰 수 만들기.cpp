#include <bits/stdc++.h>
using namespace std;

bool comp(const string &num1, const string &num2);
bool isOnlyZero(const vector<string> &numbers);
void solve();

int main() {
	solve();
	return 0;
}

bool comp(const string &num1, const string &num2) {
	if (num1 == num2) return true;
	return num1 + num2 > num2 + num1;
	
}

bool isOnlyZero(const vector<string> &numbers) {
	return numbers[0] == "0";
}

void solve() {
	int N;
	vector<string> numbers;
	
	cin >> N;
	for(int i=0; i<N; i++) {
		string number;
		cin >> number;
		numbers.push_back(number);
	}

	sort(numbers.begin(), numbers.end(), comp);

	if(isOnlyZero(numbers)) {
		cout << "0";
		return;
	}
	
	for(const string &number : numbers) {
		cout << number;
	}
}
