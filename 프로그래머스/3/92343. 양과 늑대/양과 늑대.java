import java.util.*;

class Solution {
    
    int answer;
    List<List<Integer>> tree = new ArrayList<>();
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        List<Integer> nextNodes = new ArrayList<>();
        
        for (int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
        }
        
        for (Integer i : tree.get(0)) {
            nextNodes.add(i);
        }

        dfs(0, 0, 0, nextNodes, info);
        return answer;
    }
    
    private void dfs(int sheeps, int wolfs, int curNode, List<Integer> nextNodes, int[] info) {
        if (info[curNode] == 0) sheeps++;
        else wolfs++;
        
        answer = Math.max(answer, sheeps);
        if (sheeps <= wolfs) return;
        
        for (int i = 0; i < nextNodes.size(); i++) {
            int nextNode = nextNodes.get(i);
            List<Integer> stackNodes = new ArrayList<>(nextNodes); // 다음 스택에서 참조 하므로 새로운 리스트 만들어야함
            /*
                public E remove(int index) 
                public boolean remove (Object o)
                자바 List의 remove는 두개와 같다. 따라서 int형인 nextNode를 Integer로 매핑해줘야 정상적인 Object 삭제가 가능하다.
                Integer로 매핑하지 않으면 index를 의미한다.
            */
            stackNodes.remove((Integer) nextNode);
            stackNodes.addAll(tree.get(nextNode));

            dfs(sheeps, wolfs, nextNode, stackNodes, info);
        }
    }
}