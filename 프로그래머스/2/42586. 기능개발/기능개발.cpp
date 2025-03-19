#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int> completedTime;
    
    int n = progresses.size();
    for (int i = 0; i < n; i++) {
        int progress = progresses[i];
        int speed = speeds[i];
        int time = (((100 - progress + speed - 1) / speed));
        completedTime.push_back(time);
    }
    
    vector<int> maxTimes;
    int maxTime = -1;
    for (int i = 0; i < n; i++) {
        maxTime = max(maxTime, completedTime[i]);
        maxTimes.push_back(maxTime);
    }
    
    int preTime = maxTimes[0];
    int count = 1;
    for (int i = 1; i < n; i++) {
        if (preTime == maxTimes[i]) {
            count++;
        } else {
            answer.push_back(count);
            count = 1;
        }
        preTime = maxTimes[i];
    }
    answer.push_back(count);
    
    return answer;
}