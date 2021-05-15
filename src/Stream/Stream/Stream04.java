package Stream.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//查找匹配
public class Stream04 {
    public enum status{
          free,busy,vocation
    }
    public static void test01(){
        List<status> list = Arrays.asList(status.free, status.busy, status.vocation);
        List<String> strings = Arrays.asList("a", "a", "b");
        //allMatch：检查是否匹配所有元素
        boolean flag1 = strings.stream()
                .allMatch(s -> s.equals("a"));
        //System.out.println(flag1);
        //anyMatch：检查是否至少匹配一个元素
        boolean flag2 = strings.stream()
                .anyMatch(s -> s.equals("c"));
        //System.out.println(flag2);
        //noneMatch：检查是否没有匹配所有元素
        boolean flag3 = strings.stream()
                .noneMatch(s -> s.equals("c"));
        //System.out.println(flag3);
        //findFirst：返回第一个元素
        Optional<status> first = list.stream().findFirst();
        //System.out.println(first);
        // 如果Optional为空 找一个替代的对象
        status status = first.orElse(Stream04.status.busy);
        //System.out.println(status);
        //findAny：返回当前流中的任意元素(并行流)
        Optional<status> any = list.stream().findAny();
        //System.out.println(any);
//        List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");
//        List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");
//        Optional<String> findFirst = lst1.parallelStream().filter(s -> s.startsWith("D")).findFirst();
//        Optional<String> fidnAny = lst2.parallelStream().filter(s -> s.startsWith("J")).findAny();
//        System.out.println(findFirst.get()); //总是打印出David
//        System.out.println(fidnAny.get()); //会随机地打印出Jack/Jill/Julia
//        count：返回流中元素的总个数
        long count = list.stream().count();
        //System.out.println(count);
        List<Student> students = Arrays.asList(
                new Student("a", 10),
                new Student("b", 20),
                new Student("c",15));
        //max：返回流中最大值
        int asInt = students.stream().mapToInt(s -> s.getAge()).max().getAsInt();
        System.out.println(asInt);
        //min：返回流中最小值
        int asInt1 = students.stream().mapToInt(s -> s.getAge()).min().getAsInt();
        System.out.println(asInt1);
    }

    public static void main(String[] args) {
        //test01();


    }
}
