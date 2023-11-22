#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    if (cacheSize == 0) return cities.size() * 5;
    if (cities.empty()) return 0;
    
    int answer = 0;
    for (int k = 0; k < cities.size(); k++) {
        string city = cities[k];
        string result = "";
        for (int i = 0 ; i < city.size(); i++) {
            if ('A' <= city[i] && city[i] <= 'Z') result += (city[i]+32);
            else result += city[i];
        }
        cities[k] = result;
    }
    
    deque<string> cache;
    cache.push_back(cities[0]);
    answer += 5;
    
    for (int i = 1; i < cities.size(); i++) {
        string city = cities[i];
        bool isHit = false;
        int size = cache.size();
        for (int j = 0; j < size; j++) {
            string front = cache.front();
            cache.pop_front();
            
            if (city == front) {
                isHit = true;
            } else {
                cache.push_back(front);
            }
        }

        if (isHit) {
            for (int j = 0; j < cache.size(); j++) {
                string front = cache.front();
                cache.pop_front();
                if (front != city) cache.push_back(front);
            }

            answer += 1;
        }
        else {
            answer += 5;
        }
        cache.push_back(city);

        if (cache.size() > cacheSize) {
            cache.pop_front();
        }
    }
    
    return answer;
}