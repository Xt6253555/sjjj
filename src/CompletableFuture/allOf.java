package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class allOf {
    public static void main(String[] args) {
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println(1);
        });
        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
            System.out.println(2);
        });
        //等所有CompletableFuture执行完，再进行执行
        CompletableFuture.allOf(f1,f2).whenComplete((a,b)->{
            System.out.println(a);
            System.out.println(b.getMessage());
        });
    }
}
