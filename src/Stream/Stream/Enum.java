package Stream.Stream;

public class Enum {
    public enum color{
        red,blue,green
    }

    public static void main(String[] args) {
//        System.out.println(color.blue);
//        for (color value : color.values()) {
//            System.out.println(value);
//        }
        color[] arr = color.values();
        //System.out.println(Arrays.toString(arr));
        for (color col : arr) {
            System.out.println(col+" at index "+col.ordinal());
        }
        System.out.println(color.valueOf("red"));//正常
        System.out.println(color.valueOf("black"));//报错
    }
}
