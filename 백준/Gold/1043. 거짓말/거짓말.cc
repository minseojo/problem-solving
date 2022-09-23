#include <bits/stdc++.h>
#define INF -1
using namespace std;

int N, M;
int person[52];
int party[50][52];

int find(int x) {
	if(x == -1 || person[x] == -1) return -1;
	if(x == person[x]) return x;
	else return person[x] = find(person[x]);
}

void merge(int u, int v) {
	u = find(u);
	v = find(v);

	if(u>v) person[u] = v;
	else person[v] = u;
}

int main() {
	cin >> N >> M;
	for(int i=1; i<=N; i++) person[i] = i;
	
	int trueManNumber, trueMan;
	cin >> trueManNumber;
	for(int i=0; i<trueManNumber; i++) {
		cin >> trueMan;
		person[trueMan] = INF;
	}

	for(int i=0; i<M; i++) {
		int number, mainParticipant, participant;
		cin >> number;
		party[i][0] = number;
		
		cin >> mainParticipant;
		party[i][1] = mainParticipant;
		
		if(number >= 2) {
			for(int j=2; j<=number; j++) {
				cin >> participant;
				party[i][j] = participant;
				merge(mainParticipant, participant);
			}
		}
	}
	int answer = 0;
	for(int i=0; i<M; i++) {
		for(int j=1; j<=party[i][0]; j++) {
			if(find(party[i][j]) == INF) {
				break;
			}
			if(j==party[i][0]) answer++;
		}
	}
	cout << answer;
	return 0;
}