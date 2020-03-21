import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(100);
        list.add(200);
        list.add(300);
        Stream stream = list.stream();
        Stream<Integer> integerStream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        Stream<Integer> newStream =  integerStream.filter(s -> s>5)
                .distinct()
                .skip(2)
                .limit(2);
        newStream.forEach(System.out::println);

        List<String> list2 = Arrays.asList("a,b,c", "1,2,3");




    }


}
