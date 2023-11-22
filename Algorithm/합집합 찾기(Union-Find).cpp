#include <iostream>

using namespace std;

int parent[11];

// �θ� ��带 ã�� �Լ�
int getParent(int x) {
	if (parent[x] == x) return x;
	else return parent[x] = getParent(parent[x]);
}

// �� �θ� ��带 ��ġ�� �Լ�
int unionParent(int a, int b) {
	a = getParent(a);
	b = getParent(b);
	// �� ���� �� ���� ��ħ
	if (a < b) parent[b] = a;
	else parent[a] = b;
}

// ���� �θ� �������� Ȯ���ϴ� �Լ�
int findParent(int a, int b) {
	a = getParent(a);
	b = getParent(b);
	if (a == b) return 1;
	else return 0;
}

int main() {
	for (int i = 1; i <= 10; i++) {
		parent[i] = i;
	}
	// 1 2 3 4 ���� 
	unionParent(1, 2);
	unionParent(2, 3);
	unionParent(3, 4);
	// 5 6 7 8 ���� 
	unionParent(5, 6);
	unionParent(6, 7);
	unionParent(7, 8);
	cout << "1�� 5�� ����Ǿ� �ֳ���? " << findParent(1, 5) << endl;
	// 2 8 ����  => 1 2 3 4 5 6 7 8 ��� ���� 
	unionParent(2, 8);
	cout << "1�� 5�� ����Ǿ� �ֳ���? " << findParent(1, 5) << endl;
	return 0;
}