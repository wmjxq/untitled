package edu.xcdq;

public class Main {

    public static void main(String[] args) {
        // 字符串的创建
        String s = "helloworld";  // 由于字符串比较常用，直接赋值，系统认定很常用，helloworld，放在常量池，很难回收
        String s1 = new String("hello");  //  只开辟空间，不放在常量池，用完就回收
        System.out.println(s);
        System.out.println(s1);


        String s2 = new String();
        s2 = "world";
    }
}
