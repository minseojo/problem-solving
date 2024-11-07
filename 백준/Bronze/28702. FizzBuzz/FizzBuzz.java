import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        int d = -1;
        if (Character.isDigit(a.charAt(0))) d = Integer.parseInt(a) + 3;
        else if (Character.isDigit(b.charAt(0))) d = Integer.parseInt(b) + 2;
        else if (Character.isDigit(c.charAt(0))) d = Integer.parseInt(c) + 1;

        if (d % 3 == 0 && d % 5 == 0) System.out.println("FizzBuzz");
        else if (d % 3 == 0) System.out.println("Fizz");
        else if (d % 5 == 0) System.out.println("Buzz");
        else System.out.println(d);
    }
}
