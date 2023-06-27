#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
};

void initNodeStat(Node **head, Node **cur, int n, int k){
    for(int i = 0; i < n; i++){
        Node* newNode = new Node();
        newNode->data = i;
        newNode->prev = *cur;
        (*cur)->next = newNode;
        *cur = newNode;
    }
    *cur = (*head)->next;
    for(int i = 0; i < k; i++){
        *cur = (*cur)->next;
    }
}

void moveUp(Node **cur, string s){
    int x = stoi(s.substr(2));
    for(int j = 0; j < x; j++) *cur = (*cur)->prev;
}

void moveDown(Node **cur, string s){
    int x = stoi(s.substr(2));
    for(int j = 0; j < x; j++) *cur = (*cur)->next;
}

void deleteCur(Node **cur, stack <Node*> &deletedStack){
    deletedStack.push(*cur);
    if((*cur) -> next == NULL) {
        *cur = (*cur)->prev;
        (*cur) -> next = NULL;
    }
    else {
        (*cur)->prev->next = (*cur)->next;
        (*cur)->next->prev = (*cur)->prev;
        *cur = (*cur)->next;
    }
}

void undoNode(stack <Node*> &deletedStack){
    Node *deletedNode = deletedStack.top();
    deletedStack.pop();
    Node *previous = deletedNode->prev;
    Node *next = deletedNode -> next;
    if(next != NULL){
        previous->next = deletedNode;
        next->prev = deletedNode;
    }
    else{
        previous->next = deletedNode;
    }
}

void conductCommand(vector<string> cmd, Node *cur, stack <Node*> &deletedStack){
    for(int i = 0; i < cmd.size(); i++){
        char command = cmd[i][0];
        if(command == 'U') moveUp(&cur, cmd[i]);
        if(command == 'D') moveDown(&cur, cmd[i]);
        if(command == 'C') deleteCur(&cur, deletedStack);
        if(command == 'Z') undoNode(deletedStack);
    }
}

string solution(int n, int k, vector<string> cmd) {
    string answer = "";
    Node *head = new Node();
    head -> prev = NULL;
    Node *cur = head;

    stack <Node*> deletedStack;
    vector <int> rowStat(n,0);
    initNodeStat(&head,&cur,n,k);
    conductCommand(cmd,cur,deletedStack);

    cur = head->next;
    while(cur != NULL){
        rowStat[cur->data] = 1;
        cur = cur->next;
    }

    for(int i = 0; i < n; i++){
        if(rowStat[i]) answer+="O";
        else answer+="X";
    }
    
    return answer;
}