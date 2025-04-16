import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Candidate {
        int id, count, lastTime;

        Candidate(int id, int count, int lastTime) {
            this.id = id;
            this.count = count;
            this.lastTime = lastTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());

        Map<Integer, Candidate> students = new HashMap<>();
        TreeSet<Candidate> pq = new TreeSet<>((a, b) -> {
            if (a.count == b.count) {
                return Integer.compare(a.lastTime, b.lastTime);
            }
            return Integer.compare(a.count, b.count);
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (students.containsKey(x)) {
                Candidate c = students.get(x);
                pq.remove(c);
                c.count++;
                pq.add(c);
            } else {
                if (pq.size() >= n) {
                    Candidate removed = pq.pollFirst();
                    students.remove(removed.id);
                }
                Candidate newCandidate = new Candidate(x, 1, i);
                students.put(x, newCandidate);
                pq.add(newCandidate);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Candidate c : pq) {
            result.add(c.id);
        }
        Collections.sort(result);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
