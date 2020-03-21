import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class countWords {

    public static void main(String[] args) {
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            System.out.println(path);
            FileReader reader = new FileReader("E:\\IntelliJ IDEA\\core\\microservice-demo\\src\\main\\resources\\file\\abc.txt");
            int count = 0;
            int currentChar;
            while((currentChar=reader.read())!=-1){
                if(currentChar==' ' || currentChar == '\n'
                        || currentChar == '\t' || currentChar == '\r'){
                    count++;

                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
