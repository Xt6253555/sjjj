package CompletableFuture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

//CompletableFuture的超时处理
public class get {
    public static void get(){
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        try {
            System.out.println(future.get(300, TimeUnit.MILLISECONDS));
            //超时不输出此结果
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        get();
    }
}
