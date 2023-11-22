// Âü°í https://it-earth.tistory.com/129?category=364408 
#include <bits/stdc++.h>
using namespace std;

typedef struct {
	string name;
	int age, height, weight;
}Person;

bool compare(const Person& p1, const Person& p2) {

	if(p1.height == p2.height) {
		if(p1.weight == p2.weight) {
			return p1.age < p2.age;
		}
		else return p1.weight < p2.weight;
	}
	else return p1.height > p2.height;
}
int main() {
	Person persons[10];
	persons[0].name = "jomonso";
	persons[0].age = 22; 
	persons[0].height = 175;
	persons[0].weight = 57;
	 
	persons[1].name = "acx";
	persons[1].age = 15; 
	persons[1].height = 210;
	persons[1].weight = 88;
	
	persons[2].name = "erwsdx";
	persons[2].age = 19; 
	persons[2].height = 210;
	persons[2].weight = 88;
	
	persons[3].name = "borf";
	persons[3].age = 22; 
	persons[3].height = 300;
	persons[3].weight = 57;
	
	sort(persons, persons+4, compare);
	for(int i=0; i<=3; i++) {
		cout << persons[i].name << " " << persons[i].age << " " << persons[i].height << " " << persons[i].weight << endl;
	}
}
