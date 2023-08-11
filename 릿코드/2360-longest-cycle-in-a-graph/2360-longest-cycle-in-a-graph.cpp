class Solution {
public:
    bool finished[100001];
    bool visited[100001];
    int cycle[100001];

    void findCycle(int here, vector<int>& edges) {
        visited[here] = true;
        int next = edges.at(here);
        if(next == -1) return;
        if(!visited[next]) {
            findCycle(next, edges);
        } else if(!finished[next]) { // 방문 했고, 아직 끝나지 않은 경우 사이클
            cycle[next] = 1;
        }
        finished[here] = true;
    }

    int travleCycle(int here, int count, vector<int> &edges) {
        visited[here] = true;
        int next = edges.at(here);
        int result = count;
        if(next == -1) return 0;
        if(!visited[next]) {
            result = max(result, travleCycle(next, count+1, edges));
        }
        cycle[here] = result;
        return result;
    }

    int longestCycle(vector<int>& edges) {
        int size = edges.size();

        for(int i=0; i<size; i++) {
            if(!visited[i]) findCycle(i, edges);
        }

        memset(visited, false, sizeof(visited));
        for(int i=0; i<size; i++) {
            if(cycle[i] == 1 && !visited[i]) {
                travleCycle(i, 1, edges);
            }
        }

        int answer = -1;
        for(int i=0; i<size; i++) {
            if(cycle[i] != 0 && edges.at(i) != -1) answer = max(answer, cycle[i]);
            cout << cycle[i] << " ";
        }
        return answer;
    }

};