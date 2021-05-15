package JOffice;

public class demo3 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
    public static String replaceSpace(String s) {
        return s.replaceAll("\\s","%20");
    }
}
