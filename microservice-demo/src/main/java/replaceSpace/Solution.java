package replaceSpace;

public class Solution {
    public String replace(StringBuffer str1){
        StringBuffer str2 = new StringBuffer();
        String a = "%20";
        for (int i=0;i<str1.length()-1;i++){
            char b = str1.charAt(i);
            if(!String.valueOf(b).equals(" ")){
                str2.append(b);
            }else{
                str2.append(a);
            }
        }
        return str2.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("we are lucky!");
        Solution solution = new Solution();
        String a = solution.replace(stringBuffer);
        System.out.println(a);
    }
}
