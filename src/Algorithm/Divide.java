package Algorithm;
//分治算法（解决汉诺塔）
public class Divide {
    public static void main(String[] args) {
        divide(3,'a','b','c');
    }
    public static void divide(int num,char a,char b,char c){
        if(num==1){
            System.out.println("第1个盘从 "+a+"->"+c);
        }else {
            divide(num-1,a,c,b);//(3,a,b,c)->(2,a,c,b)->(1,a,c,b)
            System.out.println("第"+num+"个盘从 "+a+"->"+c);
            divide(num-1,b,a,c);
        }
    }

}
