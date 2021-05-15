package Recursion;

public class Queen8 {
    int max =8;
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;
    public static void main(String[] args) {

    //测试一把 ， 8皇后是否正确
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount);
    }
    //编写一个方法，放置第n个皇后
    private void check(int n){
        if(n==max){
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后 n , 放到该行的第1列
            array[n]=i;
            //判断当放置第n个皇后到i列时，是否冲突
            if(judge(n)){
                check(n+1);
            }
            //如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得 后移的一个位置
        }
    }
    //查看当我们放置第n个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[i]-array[n])){
                return false;
            }
        }
        return true;
    }
    //写一个方法，可以将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"");
        }
        System.out.println();
    }
}
