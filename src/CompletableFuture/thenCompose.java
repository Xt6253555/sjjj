package CompletableFuture;

import java.util.concurrent.CompletableFuture;

//thenCompose 方法允许你对两个 CompletionStage 进行流水线操作，
// 第一个操作完成时，将其结果作为参数传递给第二个操作。
public class thenCompose {
    public static void main(String[] args) {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            return "a";
        }).thenCompose(cf2->CompletableFuture.supplyAsync(()->{
            return cf2+"b";
        }));
        System.out.println(cf1.join());
    }
}
