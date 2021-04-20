package com.wanda;

import java.awt.*;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        System.out.println("登录菜单");
        System.out.println("1 登录系统");
        System.out.println("2 退出");
        System.out.println("请输入你要的功能编号");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) { // 用于判断是否为整数
            int bianhao = scanner.nextInt();
            if ( bianhao == 1){
                System.out.println("你已进入购物管理系统，欢迎使用");
                System.out.println("1 客户信息管理");
                System.out.println("2 购物结算");
                System.out.println("3 真情回馈");
                System.out.println("4 注销");
                if ( scanner.hasNextInt()){
                    int secbiaohao = scanner.nextInt();
                    switch ( secbiaohao ){
                        case 1:
                            System.out.println("购物管理系统>客户信息管理");
                            System.out.println("1 显示所有客户信息");
                            System.out.println("2 添加客户信息");
                            System.out.println("3 修改客户信息");
                            System.out.println("4 查询客户信息");
                            int bianhaosan = scanner.nextInt();
                            switch (bianhaosan){
                                case 1:
                                    System.out.println("张三");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("购物管理系统>购物结算");
                            System.out.println("请输入消费金额：");
                            int biaohaosi = scanner.nextInt();
                            System.out.println("是否参加优惠换购：");
                            System.out.println("1：满50元，加2元换百事可乐");
                            System.out.println("2：满100元，加3元换500ml可乐");
                            System.out.println("3：满100元加10元换面粉");
                            System.out.println("4：满200元加10元换锅");
                            System.out.println("5：满200元加20元换水");
                            System.out.println("0：不换购");
                            System.out.println("请选择：");
                            int bianhaowu = scanner.nextInt();

                            System.out.print("本次消费总金额：" );
                            System.out.print(biaohaosi);
                            break;
                        case 3:
                            System.out.println("购物管理系统>真情回馈");
                            System.out.println("1 幸运大放送");
                            System.out.println("2 幸运抽奖");
                            System.out.println("3 生日问候");
                            break;
                        case 4:
                            System.out.println("注销");
                            break;
                    }
                }

            }else if ( bianhao == 2){
                System.out.println("你已退出，感谢光临");
            }else {
                System.out.println("你输入的编号不符合要求");
            }

        }else {
            System.out.println("你输入的不是整数，请重新输入");
        }
    }
}
