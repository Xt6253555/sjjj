package CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

//CompletableFuture.completedFuture是一个静态辅助方法，
// 用来返回一个已经计算好的CompletableFuture。
public class completedFuture {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        CompletableFuture<List<Integer>> future = CompletableFuture.completedFuture(list);
        System.out.println(future.join());
    }
}
