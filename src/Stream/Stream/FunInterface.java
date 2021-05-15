package Stream.Stream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//函数式接口
public class FunInterface {
    public static void test01(){
        int a = 5;
        Consumer<Integer> con = x-> System.out.println(x);
        con.accept(100);
    }
    public static void test02(){
        Supplier<Integer> supplier = () -> (int)(Math.random() * 10);
        System.out.println(supplier.get());
    }
    public static void test03(){
        String order = "abcde";
        Function<String,String> function = (s)->s.substring(2,5);
        System.out.println(function.apply(order));
    }
    public static void test04(){
        Predicate<Integer> predicate = s->s>35;
        System.out.println(predicate.test(20));
    }
    public static void main(String[] args) {
        //test01();
        //test02();
        //test03();
        test04();
    }
}
