package CompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//当CompletableFuture的计算结果完成，或者抛出异常的时候
//handle,whenComplete 和 exceptionally 类似
//handle有返回值，whenComplete无返回值
//exceptionally直接处理异常，不进行传值

public class exceptionally {
    public static void exceptionally(){
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            int i = 1/0;
            return 1;
        }).exceptionally(s->{
            System.out.println(s.getMessage());
            return 2;
        });
        System.out.println(cf1.join());
    }
    public static void whenComplete(){
        CompletableFuture<List<Integer>> cf1 = CompletableFuture.supplyAsync(() -> {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        });
        cf1.whenComplete((a, b) -> {
            a.add(2);
            System.out.println(a);
            System.out.println(b.getMessage());
            System.out.println("执行完成");
        });
    }
    public static void handle(){
        CompletableFuture<List<Integer>> cf1 = CompletableFuture.supplyAsync(() -> {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int i = 1/0;
            return list;
        });
        CompletableFuture<Integer> handle = cf1.handle((a, b) -> {
            System.out.println(a);
            System.out.println(b.getMessage());
            return 2;
        });
    }
    public static void main(String[] args) {
//        whenComplete();
        handle();

    }
}
