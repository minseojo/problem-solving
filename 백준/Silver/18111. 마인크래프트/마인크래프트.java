import com.sun.source.tree.BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = new int[2];
        result[0] = 256 * 500 * 500;
        result[1] = -1;
        for (int maxHeight = 0; maxHeight <= 256; maxHeight++) {
            int blockCount = b;
            int time = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int workBlockCount = Math.abs(maxHeight - a[i][j]);
                    if (a[i][j] > maxHeight) {
                        time += (workBlockCount * 2);
                        blockCount += workBlockCount;
                    } else if (a[i][j] < maxHeight) {
                        time += workBlockCount;
                        blockCount -= workBlockCount;
                    }
                }
            }
            if (blockCount >= 0 && result[0] >= time) {
                result[0] = time;
                result[1] = maxHeight;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
