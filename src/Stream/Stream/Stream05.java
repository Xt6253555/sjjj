package Stream.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//归约/收集
public class Stream05 {
    public static void test01(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //提供初始值，依次计算
        //归约：reduce(T identity, BinaryOperator) / reduce(BinaryOperator)
        // 可以将流中的数据反复结合起来，得到一个值
        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        //System.out.println(reduce);
        List<Student> student = Arrays.asList(new Student("a", 15),
                new Student("b",20),
                new Student("a",10));
        //收集：collect 将流转换成其他形式；
        //接收一个 Collector 接口的实现，用于给流中元素做汇总的方法
        //放入list集合
        List<String> collect = student.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        //collect.forEach(System.out::println);
        //放入set集合
        Set<String> set = student.stream()
                .map(Student::getName)
                .collect(Collectors.toSet());
        //set.forEach(System.out::println);
        //放入LinkedHashSet
        LinkedHashSet<String> linkedHashSet = student.stream()
                .map(Student::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        //linkedHashSet.forEach(System.out::println);
        //计算总数
        Long count = student.stream()
                .collect(Collectors.counting());
        //平均值
        Double avg = student.stream()
                .collect(Collectors.averagingDouble(Student::getAge));
//        System.out.println(avg);
        //总和
        Double sum = student.stream()
                .collect(Collectors.summingDouble(Student::getAge));
//        System.out.println(sum);
        //最大值
        Optional<Student> max = student.stream()
                .collect(Collectors.maxBy((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())));
        Optional<Integer> integer = max.map(Student::getAge);
        //System.out.println(integer.get());
        //最小值
        Optional<Student> min = student.stream()
                .collect(Collectors.minBy((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())));
        //分组
        Map<String, List<Student>> map = student.stream()
                .collect(Collectors.groupingBy(Student::getName));
        //System.out.println(map);
        //多级分组
        Map<String, Map<Object, List<Student>>> map1 = student.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(e -> {
                    if (e.getAge() < 15) {
                        return "a";
                    }else{
                        return "b";
                    }
                })));
//        System.out.println(map1);
        //分区
        Map<Boolean, List<Student>> map2 = student.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() < 15));
//        System.out.println(map2);
        //总结
        DoubleSummaryStatistics dss = student.stream()
                .collect(Collectors.summarizingDouble(Student::getAge));
//        System.out.println(dss.getMax());
//        System.out.println(dss.getMin());
//        System.out.println(dss.getSum());
//        System.out.println(dss.getCount());
//        System.out.println(dss.getAverage());
        //添加分隔符
        String collect1 = student.stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
//        System.out.println(collect1);
        //reduce累加得到一个值
        Optional<Integer> result = student.stream()
                .map(e -> 5)
                .reduce(Integer::sum);
//        System.out.println(result.get());

        Stream<Integer> stream = student.stream()
                .map(e -> e.getAge() * e.getAge());
        stream.forEach(System.out::println);

    }

    public static void main(String[] args) {
        test01();
    }
}
