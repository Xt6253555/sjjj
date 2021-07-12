package Stream.Stream;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

//optional类测试案例
public class OptionalTest {
//    Optional.of(T t)：创建一个 Optional 实例
//    Optional.empty(T t)：创建一个空的 Optional 实例
//    Optional.ofNullable(T t)：若 t 不为 null，创建 Optional 实例，否则空实例
//    isPresent()：判断是否包含某值
//    orElse(T t)：如果调用对象包含值，返回该值，否则返回 t
//    orElseGet(Supplier s)：如果调用对象包含值，返回该值，否则返回 s 获取的值
//    map(Function f)：如果有值对其处理，并返回处理后的 Optional，否则返回 Optional.empty()
//    flatmap(Function mapper)：与 map 相似，要求返回值必须是 Optional

    public static void test01(){
        Optional<Student> op = Optional.of(new Student());
//        System.out.println(op.get());
        Optional<Student> empty = Optional.empty();
//        System.out.println(empty.get());
        Optional<Student> o = Optional.ofNullable(new Student("a",6));
        if(o.isPresent()){
            System.out.println(o.get());
        }
    }
    public static void main(String[] args) {
        //test01();
    }
}
