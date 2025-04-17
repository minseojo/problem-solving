import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Student {
        String id;
        int index;

        Student(String id, int index) {
            this.id = id;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Map<String, Student> studentIndexes = new HashMap<>(); // id, student
        for (int i = 0; i < l; i++) {
            String id = br.readLine();
            studentIndexes.put(id, new Student(id, i));
        }

        List<Student> students = new ArrayList<>();
        for (Student s : studentIndexes.values()) {
            students.add(s);
        }
        students.sort((s1, s2) -> Integer.compare(s1.index, s2.index));

        int maxSize = Math.min(students.size(), k);
        for (int i = 0; i < maxSize; i++) {
            System.out.println(students.get(i).id);
        }

    }
}
