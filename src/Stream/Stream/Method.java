package Stream.Stream;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

//方法引用
public class Method {
    //实例方法
    public static void test01(){
        PrintStream ps = System.out;
        Consumer<String> con = (s)->ps.println(s);
        con.accept("aaa");
        Consumer<String> con2 = ps::println;
        con2.accept("bbb");
    }
    //静态方法
    public static void test02(){
        Comparator<Integer> com1 = (x,y)->Integer.compare(x,y);
        System.out.println(com1.compare(1,2));
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(2,0));
        Comparator<String> com = String::compareTo;
        System.out.println(com.compare("1","3"));
    }
    public static void test03(){
        BiPredicate<String,String> bp1 = (x,y)->x.equals(y);
        System.out.println(bp1.test("1","1"));
        BiPredicate<String,String> bp2 = String::equals;
        System.out.println(bp2.test("1","2"));
    }
    public static void main(String[] args) {
        //test01();
        //test02();
        test03();
    }
}
