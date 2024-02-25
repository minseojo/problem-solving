import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int na = Integer.parseInt(st.nextToken());
        int nb = Integer.parseInt(st.nextToken());
        Set<Integer> a = new TreeSet<>();
        Set<Integer> b = new TreeSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        while (na-- > 0) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        while (nb-- > 0) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        a.removeAll(b);
        System.out.println(a.size());
        Iterator<Integer> iter = a.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
