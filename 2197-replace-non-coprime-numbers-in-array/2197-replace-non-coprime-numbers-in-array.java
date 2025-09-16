class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int num : nums) {
            int cur = num;

            while (!stack.isEmpty()) {
                int last = stack.peekLast();
                int gcd = GCD(cur, last);
                if (gcd == 1) break;

                stack.pollLast();
                cur = LCM(cur, last);
            }

            stack.add(cur);
        }

        return stack.stream().toList();
    }

    int LCM(int a, int b) {
        return (int) (((long)a * b) / GCD(a, b));
    }

    int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}