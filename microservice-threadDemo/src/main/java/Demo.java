import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) {
        MyExecutor myExecutor = new MyExecutor();
        ThreadPoolExecutor a = new ThreadPoolExecutor(20,50,10, TimeUnit.DAYS,new LinkedBlockingDeque<>());
        StringBuffer sdf = new StringBuffer();
        try {
            myExecutor.run();
            System.out.println("你先睡，我回家啦");
        }catch (Exception e){
            throw new RuntimeException("业务程序报错啦！！！！");
        }
        

    }
}
