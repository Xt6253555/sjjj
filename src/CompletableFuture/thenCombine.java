package CompletableFuture;

import java.util.concurrent.CompletableFuture;

//thenCombine 会把 两个 CompletionStage 的任务都执行完成后，
// 把两个任务的结果一块交给 thenCombine 来处理。
//thenAcceptBoth和runAfterBoth与thenCombine类似
public class thenCombine {
    public static void main(String[] args) {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            return "a";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            return "b";
        }),(f1,f2)->{
            return f1+f2;
        });
        System.out.println(cf1.join());
    }
}
