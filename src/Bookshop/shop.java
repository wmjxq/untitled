package Bookshop;

import java.util.Scanner;

/***
 * @date
 * @aythor weimengjie
 */
public class shop {
    Scanner scanner = new Scanner(System.in);
    book bk = new book();

    public void initial() {
        bk.name[0] = "Java基础教程";
        bk.count[0] = 0;
        bk.date[0] = "2015-7-1";
        bk.state[0] = 0;

        bk.name[1] = "数据库技术";
        bk.count[1] = 0;
        bk.state[1] = 1;

        bk.name[2] = "人月神话";
        bk.state[2] = 1;
        bk.count[2] = 0;

    }

    public void kaishi() {
        boolean flag = true;
        do {
            System.out.println("欢 迎 使 用 图 书 管 理 系 统");
            System.out.println("**************************************");
            System.out.println("1. 新 增 图 书");
            System.out.println("2. 查 看 图 书");
            System.out.println("3. 删 除 图 书");
            System.out.println("4. 借 出 图 书");
            System.out.println("5. 归 还 图 书");
            System.out.println("6. 退 出");
            System.out.print("****************************************\n");
            System.out.print("请选择： ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("--->新增图书");
                    xinzeng();
                    break;
                case 2:
                    System.out.println("--->查看图书");
                    chakan();
                    break;
                case 3:
                    System.out.println("--->删除图书");
                    delete();
                    break;
                case 4:
                    System.out.println("--->借出图书");
                    sell();
                    break;
                case 5:
                    System.out.println("--->归还图书");
                    gaveme();
                    break;
                case 6:
                    System.out.println("--->您已退出");
                    flag= false;
                    break;
            }
        } while (flag == true);
    }


    //    归还书籍
//    归还时把state换成 1
//    有大bug
    private void gaveme() {
        System.out.println("请你输入你要还的书的名字");
        String name = scanner.next();

        for (int i = 0; i < bk.name.length; i++) {
            if (bk.name[i].equals(name) && bk.state[i] == 0) {
                bk.state[i] = 1;
                System.out.println("还书成功");
                break;
            } else if (bk.name[i] == null) {
                System.out.println("没有找到匹配信息");
            }

        }

    }

    //借出图书
    //借出之后在图书的.之后的借出更改为已借出，借出次数加一，在输入借出时间
    //有小bug  借出[1]书的时候 [2]直接没有了
    private void sell() {
        //  System.out.println("请输入你要借的书的编号");
        //  int bh = scanner.nextInt();
        System.out.println("请输入你要借的书本的名字");
        String name = scanner.next();
        for (int i = 0; i < bk.name.length; i++) {
            if (bk.name[i] == null) {
                System.out.println("没有找到匹配信息");
                break;
            } else if (bk.name[i].equals(bk.name[i]) && bk.state[i] == 1) {
                bk.state[i] = 0;
                bk.count[i] = +1;
                System.out.println("请输入借书的时间");
                bk.date[i] = scanner.next();
                System.out.println("借出《" + name + "》成功!");
                break;
            } else if (bk.name[i].equals(name) && bk.state[i] == 0) {
                System.out.println("不好意思，你要接的书已经被别人接走了");
            }
        }


    }

    //有大bug
    //删除图书
    //把他的下表跟最后一位空的下表更换位置就行
    private void delete() {
        boolean flag = true;
        System.out.println("请输入要删除的书的名字");
        String name = scanner.next();
        for (int i = 0; i < bk.name.length; i++) {
            if((bk.name[i].equalsIgnoreCase(name)&& bk.name[i] !=null)){
                int j = i;
                while (bk.name[j + 1] != null) {
                    bk.name[j] = bk.name[j + 1];
                    bk.state[j] = bk.state[j + 1];
                    bk.date[j] = bk.date[j + 1];
                    j++;
                }
                bk.name[j] = null;
                bk.date[j] = null;
                flag = true;
                break;
            } else{
                flag = false;

            }if( flag){
                System.out.println("删除失败");
            }else{
                System.out.println("删除成功");
            }



        }

    }

    //查看图书
    private void chakan() {
        System.out.println("序号\t 状态\t 名称\t 借出日期\t");
        for (int i = 0; i < bk.name.length; i++) {
            if (bk.name[i] == null) {

            } else if (bk.state[i] == 0) {
                System.out.println((i + 1) + "\t已借出\t" + "<<" + bk.name[i] + "》\t" + bk.date[i]);
//                break;
            } else if (bk.state[i] == 1) {
                System.out.println((i + 1) + "\t可 借\t" + "<<" + bk.name[i] + ">>" + bk.date[i] );
            }
        }
        System.out.println("******************************");

    }

    //新增图书
    private void xinzeng() {
        System.out.println("请输入要新增的图书名字");
        String name = scanner.next();
        for (int i = 0; i < bk.name.length; i++) {
            if (bk.name[i] == null) {
                bk.name[i] = name;
                bk.state[i] = 1;
                System.out.println("新增《" + name + "》成功");
                break;
            }

        }
    }

}
