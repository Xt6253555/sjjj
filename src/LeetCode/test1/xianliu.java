package LeetCode.test1;

import java.util.concurrent.atomic.AtomicInteger;

public class xianliu {
    private final int capacity; // 漏桶容量
    private final int rate; // 漏桶流出速率
    private AtomicInteger water; // 当前水量
    private long lastLeakTime; // 上次漏水时间

    public xianliu(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.water = new AtomicInteger(0);
        this.lastLeakTime = System.currentTimeMillis();
    }

    // 尝试加水，返回是否成功
    public synchronized boolean tryAddWater(int waterToAdd) {
        leak(); // 先漏水

        int currentWater = water.get();
        if (currentWater + waterToAdd <= capacity) {
            water.addAndGet(waterToAdd);
            return true; // 成功加水
        } else {
            return false; // 漏桶已满，无法加水
        }
    }

    // 漏水
    private synchronized void leak() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastLeakTime;
        int leakedWater = (int) (elapsedTime * rate / 1000); // 根据流出速率计算漏出的水量
        water.set(Math.max(0, water.get() - leakedWater)); // 更新当前水量
        lastLeakTime = currentTime; // 更新漏水时间
    }

    public static void main(String[] args) {
        xianliu leakyBucket = new xianliu(100, 10); // 漏桶容量为100，流出速率为10/s
        for (int i = 0; i < 120; i++) {
            boolean result = leakyBucket.tryAddWater(1); // 每次尝试加水1
            System.out.println("第 " + (i + 1) + " 次尝试加水：" + (result ? "成功" : "失败"));
            try {
                Thread.sleep(100); // 休眠100ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
