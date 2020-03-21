import java.util.Scanner;

public class od {
    public static void main(String[] args) {
        int[] count = new int[20];
        Scanner sc = new Scanner(System.in);
        while (true){
            String str = sc.nextLine();
            String[] strings = str.split(",");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            if(a == -1 || b == -1){
                break;
            }
            int c = a;
            while (c>=a && c<b){
                count[c]++;
                c++;
            }
        }
        System.out.println("[12,13):"+count[12]);
        System.out.println("[13,14):"+count[13]);
        System.out.println("[14,15):"+count[14]);
        System.out.println("[15,16):"+count[15]);
        System.out.println("[16,17):"+count[16]);
        System.out.println("[17,18):"+count[17]);
        System.out.println("[18,19):"+count[18]);
        System.out.println("[19,20):"+count[19]);
    }
}
