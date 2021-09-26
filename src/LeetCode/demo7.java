package LeetCode;
//整数反转
public class demo7 {
    public static void main(String[] args) {
        System.out.println(reverse(1));
    }
    public static int reverse(int x) {
        if(x==0){
            return x;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if(x>0){
                String s = String.valueOf(x);
                for (int i = s.length(); i >0; i--) {
                    stringBuilder.append(s.charAt(i-1));
                }
                return Integer.parseInt(String.valueOf(stringBuilder));
            }else {
                String s = String.valueOf(-x);
                for (int i = s.length(); i > 0; i--) {
                    stringBuilder.append(s.charAt(i-1));
                }
                return Integer.parseInt("-"+String.valueOf(stringBuilder));
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
