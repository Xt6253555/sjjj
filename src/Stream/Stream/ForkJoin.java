package Stream.Stream;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

//forkjoin框架实现
public class ForkJoin {
    public static void test01(){
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 100000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }
    //单线程计算
    public static void test02(){
        Instant start = Instant.now();
        Long sum = 0L;
        for (long i = 0; i <= 100000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }
    //java8并行流(累加,parallel())
    public static void test03(){
        long reduce = LongStream.rangeClosed(0, 100000000L)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println(reduce);
    }
    public static void main(String[] args) {
//        test01();
//        test02();
        test03();
    }
}
