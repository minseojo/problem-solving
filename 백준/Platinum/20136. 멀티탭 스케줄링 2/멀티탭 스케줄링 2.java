import com.sun.source.tree.BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int MAX = 500000;

    static class Item {
        int nextIndex;
        int value;

        Item(int nextIndex, int value) {
            this.nextIndex = nextIndex;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] need = new int[k];
        PriorityQueue<Integer>[] pq = new PriorityQueue[5000000];
        for (int i = 0; i < pq.length; i++) {
            pq[i] = new PriorityQueue<>();
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            need[i] = Integer.parseInt(st.nextToken());
            pq[need[i]].add(i);
        }

        int result = 0;
        boolean[] pluggedIn = new boolean[500001];
        PriorityQueue<Item> nextPlug = new PriorityQueue<>((i, j) -> Integer.compare(j.nextIndex, i.nextIndex));


        int plugCount = 0;
        for (int i = 0; i < k; i++) {
            int idx = need[i];
            if (pluggedIn[idx]) {
                pq[idx].poll();
                if (pq[idx].isEmpty()) {
                    nextPlug.add(new Item(Integer.MAX_VALUE, idx));
                } else {
                    nextPlug.add(new Item(pq[idx].peek(), idx));
                }
                continue;
            }

            if (plugCount < n) {
                pq[idx].poll();
                if (pq[idx].isEmpty()) {
                    nextPlug.add(new Item(Integer.MAX_VALUE, idx));
                } else {
                    nextPlug.add(new Item(pq[idx].peek(), idx));
                }
                pluggedIn[idx] = true;
                plugCount++;
            } else {
                Item next = nextPlug.peek();
                pluggedIn[next.value] = false;
                nextPlug.poll();
                pq[idx].poll();
                if (pq[idx].isEmpty()) {
                    nextPlug.add(new Item(Integer.MAX_VALUE, idx));
                } else {
                    nextPlug.add(new Item(pq[idx].peek(), idx));
                }
                pluggedIn[idx] = true;
                result++;
            }
        }

        System.out.println(result);
    }
}
