package edu.xcdq;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

    // 1 length() 是方法

public class demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        if(password.length()>=6){
            System.out.println("密码长度符合要求");
        }else {
            System.out.println("密码长度过短");
        }

        // a.length 数组 length 是属性没有()
        int [] a = new int[4];
        System.out.println(a.length);
    }
}
