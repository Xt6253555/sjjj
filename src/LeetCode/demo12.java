package LeetCode;
//12. 整数转罗马数字
public class demo12 {
    public static void main(String[] args) {
        //System.out.println(intToRoman(50));
        System.out.println(intToRoman1(50));
    }
    public static String intToRoman(int num) {
        if(num<1||num>3999){
            return "";
        }
        int a = num%10;
        int b = num%100/10;
        int c = num%1000/100;
        int d = num%10000/1000;
        String a1 ="";
        String b1="";
        String c1="";
        String d1="";
        //个位数
        if(a==0){
            a1="";
        }else if(a == 4){
            a1="IV";
        }else if(a == 9){
            a1="IX";
        }else if(0<a&&a<4){
            for (int i = 0; i < a; i++) {
                a1 = a1+"I";
            }
        }else if(4<a&&a<9) {
            for (int i = 0; i < a - 5; i++) {
                a1 = a1 + "I";
            }
            a1 = "V"+a1;
        }
        //十位数
        if(b==0){
            b1="";
        }else if(b == 4){
            b1="XL";
        }else if(b == 9){
            b1="XC";
        }else if(0<b&&b<4){
            for (int i = 0; i < b; i++) {
                b1 = b1+"X";
            }
        }else if(4<b&&b<9) {
            for (int i = 0; i < b - 5; i++) {
                b1 = b1 + "X";
            }
            b1 = "L"+b1;
        }
        //百位数
        if(c==0){
            c1="";
        }else if(c == 4){
            c1="CD";
        }else if(c == 9){
            c1="CM";
        }else if(0<c&&c<4){
            for (int i = 0; i < c; i++) {
                c1 = c1+"C";
            }
        }else if(4<c&&c<9) {
            for (int i = 0; i < c - 5; i++) {
                c1 = c1 + "C";
            }
            c1 = "D"+c1;
        }
        //千位数
        if(d==0){
            d1="";
        }else if(0<d&&d<4) {
            for (int i = 0; i < d; i++) {
                d1 = d1+"M";
            }
        }
        return d1+c1+b1+a1;
    }

    //贪心算法优化
    public static String intToRoman1(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length&&num>0; i++) {
            while (values[i]<=num){
                num = num-values[i];
                builder.append(symbols[i]);
            }
        }
        return builder.toString();
    }
}
