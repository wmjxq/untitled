package edu.xcdq;

import java.util.Scanner;
//  2 equals() 判断两个字符串是否相等
//  3 equalsIgnoreCase  不区分大小写判断是否相等
public class demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        if(name.equalsIgnoreCase("tom")&& password.equals("1234567")){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
    }
    /*
    * equals 的实现逻辑
    * 1  先判断地址是否相同，如果相同，则值一定相同，返回结果结束判断
    * 2  要求传入的判断的对象是字符串，满足要求，则
    *       2.1 先判断长度是否相等，如果相等，依次判断每一位是否相等
    *       2.2 如果长度不等，返回结果，结束判断
    * 3  如果不是字符串，结束判断，不符合要求
    */
}
