package Stream.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

//CompletableFuture组合
public class CompletableFutureExample02 {
    //时间睡眠
    public static void sleep(long seconds){
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //结合两个线程
    public static void thenAcceptBoth() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync");
            return "supplyAsync";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            System.out.println("thenAcceptBoth");
            return 100;
        }), (s, i) -> System.out.println(s + "---" + i));

        CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync2");
            return "supplyAsync2";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            return future.join();
        }), (s, i) -> System.out.println(i));
        future1.join();
    }
    //两个选择其中一个结果
    public static void acceptEither(){
        CompletableFuture.supplyAsync(()->{
            return "acceptEither1";
        }).acceptEither(CompletableFuture.supplyAsync(()->{
            return "acceptEither2";
        }), System.out::println).join();
    }
    //执行先运行完成的
    public static void acceptToEither(){
        CompletableFuture.supplyAsync(()->{
            sleep(1);
            return "acceptEither1";
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            sleep(2);
            return "acceptEither2";
        }),s -> {
            System.out.println(s);
            return s;
        }).join();
    }
    //合并两个线程
    public static void thenCombine(){
        CompletableFuture.supplyAsync(()->{
            return "1";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            return 2;
        }),(a,b)->{
            System.out.println(a);
            System.out.println(b);
            return a;
        }).join();
    }
    //连接两个线程
    public static void thenCompose(){
        CompletableFuture.supplyAsync(()->{
            return "1";
        }).thenCompose(a->CompletableFuture.supplyAsync(()->{
            System.out.println(a+"2");
            return a+"2";
        })).join();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        thenAcceptBoth();
//        acceptEither();
//        acceptToEither();
//        thenCombine();
        thenCompose();
    }
}
