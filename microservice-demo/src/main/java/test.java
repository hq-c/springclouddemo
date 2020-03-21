import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int count = 1;
        char ch = a.charAt(0);
        int max = 1;
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) == ch) {
                count++;
            } else {
                ch = a.charAt(i);
                count = 1;
            }
            if (count > max) {
                max = count;
            }
        }
        System.out.println(max);
    }
}
