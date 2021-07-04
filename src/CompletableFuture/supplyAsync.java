package CompletableFuture;

import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//创建一个异步操作，没有入参。
public class supplyAsync {
    public static void main(String[] args){
        System.out.println(1);
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "a"+"b";
        });
        System.out.println(2);
        try {
            System.out.println(cf1.get(300L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
