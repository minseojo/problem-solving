import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(a, 0, n-1, new int[n]);

        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i + "\n");
        }
        System.out.println(sb.toString());
    }

    private static void mergeSort(int[] a, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid, temp);
            mergeSort(a, mid + 1, right, temp);
            merge(a, left, mid, right, temp);
        }
    }

    private static void merge(int[] a, int left, int mid, int right, int[] temp) {
        int l = left;
        int m = mid + 1;
        int i = left;

        while (l <= mid && m <= right) {
            if (a[l] <= a[m]) {
                temp[i++] = a[l++];
            } else {
                temp[i++] = a[m++];
            }
        }

        while (l <= mid) {
            temp[i++] = a[l++];
        }

        while (m <= right) {
            temp[i++] = a[m++];
        }

        for (int j = left; j <= right; j++) {
            a[j] = temp[j];
        }
    }
}
