package Stream.Thread;


import Stream.Stream.Student;

import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest01 {
    //线程睡眠
    public static void sleepMills(long mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //打印时间戳+线程消息+消息
    public static void printTimeAndThread(String tag){
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(result);
    }
    //两个线程各自运行（supplyAsync开启异步任务）
    public static void thread01(){
        CompletableFutureTest01.printTimeAndThread("小白进入餐厅");
        CompletableFutureTest01.printTimeAndThread("小白点了番茄炒蛋+一碗米饭");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            CompletableFutureTest01.printTimeAndThread("厨师炒菜");
            CompletableFutureTest01.sleepMills(200);
            CompletableFutureTest01.printTimeAndThread("厨师炒饭");
            CompletableFutureTest01.sleepMills(100);
            return "番茄炒蛋+米饭做好了";
        });

        CompletableFutureTest01.printTimeAndThread("小白在打王者");
        CompletableFutureTest01.printTimeAndThread(String.format("%s,小白开吃",cf1.join()));
    }
    //三个线程各自运行(thenCompose连接两个异步任务)
    public static void thread02(){
        CompletableFutureTest01.printTimeAndThread("小白进入餐厅");
        CompletableFutureTest01.printTimeAndThread("小白点了番茄炒蛋+一碗米饭");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            CompletableFutureTest01.printTimeAndThread("厨师炒菜");
            CompletableFutureTest01.sleepMills(200);
            return "番茄炒蛋";
        }).thenCompose(dish -> CompletableFuture.supplyAsync(() -> {
            CompletableFutureTest01.printTimeAndThread("服务员打饭");
            CompletableFutureTest01.sleepMills(100);
            return dish+"米饭";
        }));

        CompletableFutureTest01.printTimeAndThread("小白在打王者");
        CompletableFutureTest01.printTimeAndThread(String.format("%s,小白开吃",cf1.join()));
    }
    //三个线程各自运行(thenCombine合并两个异步任务)
    public static void thread03(){
        CompletableFutureTest01.printTimeAndThread("小白进入餐厅");
        CompletableFutureTest01.printTimeAndThread("小白点了番茄炒蛋+一碗米饭");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            CompletableFutureTest01.printTimeAndThread("厨师炒菜");
            CompletableFutureTest01.sleepMills(200);
            return "番茄炒蛋";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            CompletableFutureTest01.printTimeAndThread("服务员蒸饭");
            CompletableFutureTest01.sleepMills(300);
            return "米饭";
        }),(dish,rice)->{
            CompletableFutureTest01.printTimeAndThread("服务员打饭");
            CompletableFutureTest01.sleepMills(100);
            return String.format("%s+%s好了",dish,rice);
        });
        CompletableFutureTest01.printTimeAndThread("小白在打王者");
        CompletableFutureTest01.printTimeAndThread(String.format("%s,小白开吃",cf1.join()));
    }
    //两个线程运行(将前一个结果传递给后面一个thenApply)
    public static void thread04(){
        CompletableFuture.supplyAsync(()->{
            CompletableFutureTest01.printTimeAndThread("服务员收款 500元");
            CompletableFutureTest01.sleepMills(200);
            return "500";
        }).thenApply(money->{
            CompletableFutureTest01.printTimeAndThread(String.format("服务员开发票%s元",money));
            CompletableFutureTest01.sleepMills(100);
            return String.format("%s",money);
        }).join();
    }
    //两个不同线程运行(将前一个结果传递给后面一个thenApplyAsync和henCompose类似)
    public static void thread05(){
        CompletableFuture.supplyAsync(()->{
            CompletableFutureTest01.printTimeAndThread("服务员收款 500元");
            CompletableFutureTest01.sleepMills(200);
            return "500";
        }).thenApplyAsync(money->{
            CompletableFutureTest01.printTimeAndThread(String.format("服务员开发票%s元",money));
            CompletableFutureTest01.sleepMills(100);
            return String.format("%s",money);
        }).join();
    }
    //哪个线程任务先完成，哪个先进行(applyToEither)
    public static void thread06(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            CompletableFutureTest01.printTimeAndThread("700路先到");
            CompletableFutureTest01.sleepMills(200);
            return "700路到了";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            CompletableFutureTest01.printTimeAndThread("800路先到");
            CompletableFutureTest01.sleepMills(100);
            return "800路到了";
        }), first -> first);
        CompletableFutureTest01.printTimeAndThread(String.format("%s",future));
    }
    //处理异常
    public static void thread07(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            CompletableFutureTest01.printTimeAndThread("700路先到");
            CompletableFutureTest01.sleepMills(200);
            return "700路到了";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            CompletableFutureTest01.printTimeAndThread("800路先到");
            CompletableFutureTest01.sleepMills(300);
            return "800路到了";
        }), first -> {
            CompletableFutureTest01.printTimeAndThread(first);
            if(first.startsWith("700")){
                throw new RuntimeException("错误");
            }
            return first;
        }).exceptionally(e->{
            CompletableFutureTest01.printTimeAndThread(e.getMessage());
            return "处理错误";
        });
        CompletableFutureTest01.printTimeAndThread(String.format("%s",future.join()));
    }
    public static CompletableFuture<String> recall01(){
        return CompletableFuture.supplyAsync(() -> {
            return "recall222";
        });
    }
    public static CompletableFuture<String> recall02(){
        CompletableFuture<String> future = CompletableFuture.completedFuture((new Student()))
                .thenCombine(recall01(), (dish, rice) -> {
                    return String.format("%s+%s", dish, rice);
                });
        System.out.println(String.format("%s",future.join()));
        return future;
    }
    public static void main(String[] args) {
//        thread01();
//        thread02();
//        thread03();
//        thread04();
//        thread05();
//        thread06();
//        thread07();
//        recall02();
    }
}
