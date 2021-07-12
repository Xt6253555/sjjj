package CompletableFuture;

import java.util.concurrent.CompletableFuture;

//thenCompose 方法允许你对两个 CompletionStage 进行流水线操作，
// 第一个操作完成时，将其结果作为参数传递给第二个操作。
//thenApply（）转换的是泛型中的类型，是同一个CompletableFuture；
//thenCompose（）用来连接两个CompletableFuture，是生成一个新的CompletableFuture
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
