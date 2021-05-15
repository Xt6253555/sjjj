package Stream.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample03 {
    //时间睡眠
    public static void sleep(long seconds){
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //返回最终调用值
    public static void getNow() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });
        String world = future.getNow("world");
        System.out.println(world);
        System.out.println(future.get());
    }
    public static void complete() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });
//        sleep(1);
        boolean world = future.complete("world");
        System.out.println(world);
        System.out.println(future.get());
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        getNow();
//        complete();

    }
}
