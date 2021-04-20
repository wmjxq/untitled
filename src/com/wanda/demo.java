package com.wanda;

import edu.xcdq.Main;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入4位会员号：");
        int scoer = scanner.nextInt();
        System.out.println("请输入会员生日：");
        String shengri = scanner.next();
        System.out.println("请输入积分：");
        int jifen = scanner.nextInt();

        System.out.println("已录入会员信息是:");
        System.out.println(scoer +"   " + shengri + "   " + jifen);

    }
}
