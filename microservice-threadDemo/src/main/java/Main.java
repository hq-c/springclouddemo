import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){
            sb.insert(0,str.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
