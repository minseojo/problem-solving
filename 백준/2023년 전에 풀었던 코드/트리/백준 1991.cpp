#include <bits/stdc++.h>
using namespace std;

struct node {
	char left, right;
}arr[30];

void preorder(char root) {
	if(root=='.') return;
	cout << root;
	preorder(arr[root].left);
	preorder(arr[root].right);	
}

void inorder(char root) {
	if(root=='.') return;
	inorder(arr[root].left);
	cout << root;
	inorder(arr[root].right);	
}

void postorder(char root) {
	if(root=='.') return;
	postorder(arr[root].left);
	postorder(arr[root].right);
	cout << root;	
}
int main() {
	int n;
	cin >> n;
	char a,b,c;
	
	for(int i=0; i<n; i++) {
		cin >> a >> b >> c;
		arr[a].left = b;
		arr[a].right = c;		
	}
	preorder('A');
	cout << endl;
	inorder('A');
	cout << endl;
	postorder('A');
}
