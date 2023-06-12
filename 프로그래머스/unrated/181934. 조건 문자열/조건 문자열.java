import java.util.Map;
import java.util.function.BiFunction;

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        Map<String, BiFunction<Integer, Integer, Boolean>> functions = Map.of(
                ">=", (a, b) -> a >= b,
                "<=", (a, b) -> a <= b,
                ">!", (a, b) -> a > b,
                "<!", (a, b) -> a < b
        );

        return functions.get(ineq + eq).apply(n, m) ? 1 : 0;
    }
}
/*
class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int compareVal = -1;
        
        if (n > m) compareVal = 1;
        else if (n < m) compareVal = -1;
        else if (n == m) compareVal = 0;
        
        if (compareVal == 0) {
            if(eq.equals("=")) return 1;
        }
        else if (compareVal == -1) {
            if (ineq.equals("<")) return 1;
        }
        else if (compareVal == 1) {
            if (ineq.equals(">")) return 1;
        }
        
        return 0;
    }
}
*/