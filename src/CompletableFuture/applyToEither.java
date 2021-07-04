package CompletableFuture;

import java.util.concurrent.CompletableFuture;

//两个CompletionStage，谁执行返回的结果快，
// 我就用那个CompletionStage的结果进行下一步的转化操作。
//AcceptEither和runAfterEither与applyToEither类似
public class applyToEither {
    public static void main(String[] args) {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "1";
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "2";
        }),a->a);
        System.out.println(cf1.join());
    }
}
