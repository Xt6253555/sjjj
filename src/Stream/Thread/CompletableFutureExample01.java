package Stream.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
//CompletableFuture参数传递
public class CompletableFutureExample01 {
//    whenComplete：是执行当前任务的线程执行继续执行 whenComplete 的任务。
//    whenCompleteAsync：是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行。
    public static void whenComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello")
        .whenComplete((v,t)-> System.out.println(String.format("%s--%s",v,t)));
        System.out.println(future.join());
    }
    public static void whenCompleteAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello")
                .whenCompleteAsync((v,t)-> {
                    System.out.println("start");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("end");
                });
        System.out.println(future.get());
    }
//    thenApply将上一个线程的结果进行传递
    public static void thenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> "hello")
        .thenApply(s->s.length());
        System.out.println(future.get());
    }
    public static void thenApplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> "hello")
                .thenApplyAsync(s->{
                    System.out.println("start");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("end");
                    return s.length();
                });
        System.out.println(future.get());
    }
//    handle
    public static void handleAsync(){
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> "hello")
                .handleAsync((s, t) -> {
                    System.out.println(s.length());
                    System.out.println(t);
                    return s;
                });
        System.out.println(future);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        whenComplete();
//        whenCompleteAsync();
//        thenApply();
//        thenApplyAsync();
        handleAsync();
    }
}
