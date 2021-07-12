package CompletableFuture;

import java.util.concurrent.CompletableFuture;

//thenCombine 会把 两个 CompletionStage 的任务都执行完成后，
// 把两个任务的结果一块交给 thenCombine 来处理。
//thenAcceptBoth和runAfterBoth与thenCombine类似
public class thenCombine {
    public static void thenCombine01(){
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            return "a";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            return "b";
        }),(f1,f2)->{
            System.out.println(f1);
            System.out.println(f2);
            return f1+f2;
        });
        System.out.println(cf1.join());
    }
    public static void thenCombine02(){
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->{
            return "a";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            return "b";
        });
        CompletableFuture<String> cf1 = f1.thenCombine(f2, (c1, c2) -> {
            System.out.println(c1);
            System.out.println(c2);
            return "c";
        });
        System.out.println(cf1.join());
    }
    public static void main(String[] args) {
        thenCombine02();
    }
}
