package edu1.xcdq;

import java.util.Scanner;

public class demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字键：");
        int shu = scanner.nextInt();
        switch ( shu ){
            case 1:
                System.out.println("拨爸爸的号");
                break;
            case 2:
                System.out.println("拨妈妈的号");
                break;
            case 3:
                System.out.println("拨爷爷的号");
                break;
            case 4:
                System.out.println("拨奶奶的号");
                break;
        }
        /*System.out.println("请输入你的名次：");
        int count = scanner.nextInt();*/
        /*if (count == 1 ){
            System.out.println();
        }
        if ( count == 2){
            System.out.println();
        }
        if ( count == 3){
            System.out.println();
        }*/

        /*switch ( count ){
            case 1:
                System.out.println("xialy");
                break;
            case 2:
                System.out.println("笔记本");
                break;
            case 3:
                System.out.println("硬盘");
                break;
        }*/
    }
}
