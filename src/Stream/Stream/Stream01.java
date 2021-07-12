package Stream.Stream;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream01 {
    public static void test01(){
        //集合流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        //数组流
        Integer[] arr = {1,2,3,4};
        Stream<Integer> stream2 = Arrays.stream(arr);
        //静态方法
        Stream<Integer> stream3 = Stream.of(1, 2, 3);
        //迭代实现无限流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(2)
                .forEach(System.out::println);
        //生成流
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        test01();

    }
}
