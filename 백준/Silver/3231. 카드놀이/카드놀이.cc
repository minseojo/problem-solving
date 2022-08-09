#include <bits/stdc++.h>
using namespace std;

struct Card{
	int number;
	int index;	
};
vector<Card> card;

bool comp(Card& c1, Card& c2) {
	return c1.number < c2.number;
}

int main() {
	int N;
	cin >> N;

	int number;
	for(int i=0; i<N; i++) {
		cin >> number;
		card.push_back({number, i});
	}
	
	int answer = 0;
	sort(card.begin(), card.end(), comp);
	
	for(int i=0; i<card.size()-1; i++) {
		if(card[i].index > card[i+1].index) answer += 1;
	}
	
	cout << answer;
	
	return 0;
}
