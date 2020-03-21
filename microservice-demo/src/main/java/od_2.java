import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class od_2 {
    public static void main(String[] args) {
        Map map = new HashMap();
        String[] str = {"2T","300G","20M"};
        int[] data = new int[str.length];
        for(int i=0;i<str.length;i++){
            int a =Integer.parseInt(str[i].substring(0,str[i].length()-1));
            String b = str[i].substring(str[i].length()-1,str[i].length());

            System.out.println(str[i]+"  "+a+"   "+ b);
            switch (b){
                case "T":
                    a = a*1000*1000;
                    break;
                case "G":
                    a = a*1000;
                    break;
                case "M":
                    a = a;
                    break;
                default:
                    a = a;
            }
            data[i] = a;
            map.put(data[i],i);
        }
        Arrays.sort(data);
        for(int j=0;j<data.length;j++){
            int num = (Integer)map.get(data[j]);
            System.out.println(str[num]);
        }
    }
}
