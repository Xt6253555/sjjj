package Stream;

import java.util.Arrays;
import java.util.List;

//并行流
public class parallelStream {
    public static void list(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //乱序输出
        numbers.parallelStream()
                .forEach(System.out::print);
        System.out.println("-------------");
        //顺序输出
        numbers.parallelStream()
                .forEachOrdered(System.out::print);

    }

    public static void main(String[] args) {
        list();
    }
}
