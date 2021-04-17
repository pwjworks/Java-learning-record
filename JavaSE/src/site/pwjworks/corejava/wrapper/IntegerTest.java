package site.pwjworks.corejava.wrapper;

public class IntegerTest {
    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1000;
        // 介于-128和127之间的short和int被包装到固定的对象中
        Integer n = 1;
        Double x = 2.0;
        System.out.println(true ? n : x); // 自动装箱
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
