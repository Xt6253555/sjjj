package CompletableFuture;

import java.util.concurrent.CompletableFuture;

//当一个线程依赖另一个线程时，
// 可以使用 thenApply 方法来把这两个线程串行化。
//thenRun和thenAccept与thenApply类似
//thenApply（）转换的是泛型中的类型，是同一个CompletableFuture；
//thenCompose（）用来连接两个CompletableFuture，是生成一个新的CompletableFuture
public class thenApply {
    public static void main(String[] args) {
        int res = 1;
        CompletableFuture<Integer> cf1= CompletableFuture.supplyAsync(()->{
            return res;
        }).thenApply(resp->{
            return resp+res+2;
        });
        System.out.println(cf1.join());
    }
}
