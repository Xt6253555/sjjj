package Stream.Stream;

import java.util.*;
import java.util.function.Consumer;

//Lambda表达式语法
public class Lambda {
    static  int num = 0;
    public static void test1(){
        Runnable r = ()->{
            System.out.println("222"+(++num));
        };
        r.run();
    }
    public static void test2(){
        Consumer<String> con = x-> System.out.println(x);
        con.accept("con");
    }
    public static void test3(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x,y);
        System.out.println(com.compare(1,2));
        List<String> list = Arrays.asList("a","d","c","b");
        Collections.sort(list, (x, y)->{
            return y.compareTo(x);
        });
        System.out.println(list);
    }
    public static void test4(){
        List<Student> ems = Arrays.asList(
              new Student("d",10),
              new Student("a",10),
              new Student("c",20)
        );
        Collections.sort(ems,(x,y)->{
            if(x.getAge()==y.getAge()){
                return x.getName().compareTo(y.getName());
            }else{
                return Integer.compare(x.getAge(),y.getAge());
            }
        });
        System.out.println(ems);
    }
    public static void test5(){
        String s = "ABCDEFG";
        MyString myString =  x-> s.toLowerCase().substring(2,4);
        System.out.println(myString.getValue(s));
    }
    public static void test6(){
        long a = 3L;
        long b = 5L;
        MyT myT = (X, y)->a*b;
        MyT myT1 = (x,y)->a+b;
        System.out.println(myT.getValue(a,b));
        System.out.println(myT1.getValue(a,b));
    }
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        test6();
    }
}
