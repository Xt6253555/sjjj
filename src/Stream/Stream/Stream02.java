package Stream.Stream;

import java.util.Arrays;
import java.util.List;

//筛选 / 切片
public class Stream02 {
    static List<Integer> emps = Arrays.asList(1,2,3,4,5,6,7);
    static List<Student> list = Arrays.asList(
            new Student("张三",10),
            new Student("李四",20),
            new Student("王五",30)
    );
    public static void test01(){
//        filter：接收 Lambda ，从流中排除某些元素
//        limit：截断流，使其元素不超过给定数量
//        skip(n)：跳过元素，返回一个舍弃了前n个元素的流；若流中元素不足n个，则返回一个空流；与 limit(n) 互补
//        distinct：筛选，通过流所生成的 hashCode() 与 equals() 取除重复元素
        emps.stream()
                .filter((x) -> x > 3)
                .limit(3)
                .distinct()
                .skip(1)
                .forEach(System.out::println);
    }
    public static void test02(){
        List<String> list = Arrays.asList("a", "b", "c");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
    }
    public static void test03(){
        list.stream()
                .filter(student -> student.getAge()>10)
                .map(student -> student.getName())
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        //test01();
        //test02();
        test03();
    }
}
