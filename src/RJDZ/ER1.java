package RJDZ;

import java.util.Scanner;

/***
 * @date 2021-04-14 12:59
 * @aythor weimengjie
 */
public class ER1 {
        boolean flag = true;
        String name;   //用户的名字
        String sj;      //电脑出的quan
        String number;   // 你出的quan
        int random = 1 + (int) (Math.random() * 3); //创建一个随机数 （0-9）
        Scanner scanner = new Scanner(System.in);
        int namefs;
        int dnfs;
        int dn; //电脑的角色
        String Myname;// 你的名字



        public void sayhello() {
            System.out.println("*********************************");
            System.out.println("**猜拳，开始**");
            System.out.println("*********************************");
            System.out.println("出拳规则：1.剪刀 2.石头 3.布");
            System.out.println("请选择对方角色（1：刘备2：孙权3：曹操");
            int dn = scanner.nextInt(); //电脑的角色
            switch (dn) {
                case 1:
                    name = "刘备";
                    break;
                case 2:
                    name = "孙权";
                    break;
                case 3:
                    name = "曹操";
                    break;
            }

            System.out.println("请输入你的姓名");
            String Myname = scanner.next();
            System.out.println(Myname + "VS" + name);


        }
        // 对决类

        public void duijue() {

            do {
                System.out.println("要开始吗？");
                String ks = scanner.next();
                flag = true;
                if (ks.equals("y")) {
                    System.out.println("请出拳：1.剪刀 2.石头 3.步（输入对应数字）：");
                    int cq = scanner.nextInt();
                    switch (cq) {
                        case 1:
                            number = "剪刀";
                            System.out.println("你出" + number);
                            break;
                        case 2:
                            number = "石头";
                            System.out.println("你出" + number);
                            break;
                        case 3:
                            number = "布";
                            System.out.println("你出" + number);
                    }

                    if (random == 1) {
                        sj = "剪刀";
                    } else if (random == 2) {
                        sj = "石头";
                    } else if (random == 3) {
                        sj = "布";
                    } else {
                        System.out.println("随机错误");
                    }
                    System.out.println(name + "出" + sj);


                    flag = true;

                    if (cq == random && (number.equals(sj))) {
                        System.out.println("平局");

                    } else if (cq > random && random + 1 == cq || cq + 2 == random) {
                        System.out.println("你赢");
                        namefs++;
                        System.out.println( "你的分数"+namefs);

                    } else if ((random > cq) && (cq + 1 == random) || random + 2 == cq) {//
                        System.out.println(name + "赢");
                        dnfs++;
                        System.out.println( name+"分数"+dnfs);
                    }
                    jxm();


                    flag = false;

                    System.out.println("您已推出");
                }

            }while(flag);

        }


        public void jxm() {
            System.out.println("还要继续吗?");
            String a = scanner.next();
            if (a.equals("y")) {
                duijue();
            }if(a.equals("n")){

                flag = false;

            }
        }
    }





