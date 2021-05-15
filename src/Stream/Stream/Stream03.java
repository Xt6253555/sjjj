package Stream.Stream;

import java.util.*;
import java.util.stream.Stream;

//映射
public class Stream03 {
//    map：接收 Lambda ，将元素转换为其他形式或提取信息；
//    接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
//    flatMap：接收一个函数作为参数，将流中每一个值都换成另一个流，然后把所有流重新连接成一个流
    public static void test01(){
        List<String> list = Arrays.asList("a", "B", "c");
        list.stream()
                .map(s->s.toUpperCase())
                .filter(s->s!="a")
                .forEach(System.out::println);
    }
    //字符串转字符集合
    public  static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
    public static void test02() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
//        list.stream()
//                .flatMap(Stream03::filterCharacter)
//                .forEach(System.out::println);
        Stream<Stream<Character>> stream = list.stream().map(Stream03::filterCharacter);
        stream.forEach(sm->sm.forEach(System.out::println));
    }
    public static void test03(){
        List<Student> list = Arrays.asList(new Student("a", 20),
                new Student("b", 10),
                new Student("a", 30));
//        list.stream()
//                .sorted(Comparator.comparing(Student::getAge))
//                .sorted(Comparator.comparing(Student::getName))
//                .forEach(System.out::println);
        list.stream()
                .sorted((e1, e2) -> { //compara()
                    if (e1.getAge()==e2.getAge()){
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return Integer.compare(e1.getAge(),e2.getAge());
                    }
                })
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        //test01();
        //test02();
        test03();
    }
}
