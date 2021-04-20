package Bookshop;

import java.util.Scanner;

/**
 * 初始化数组： 第一本图书的书名：平凡的世界； state[0] = 0：表示已经借出； date[0] = 1：表示1号借出；
 * count[0] = 12：表示已经借出12次。
 * @author 18409
 *
 */
public class BookManager {
    public static void main(String[] args) {
        /*
         * 创建数组存储图书信息
         */
        String[] bookname = new String[7];// 创建存储图书名称数组
        int[] bookstate = new int[7];// 借出状态：
        int[] bookdate = new int[7];   //借出日期
        int[] bookcount = new int[7];// 借出次数
        /*
         * 判断用户是否选着退出或是非法操作 1为初始值 2为退出，或非法操作
         */
        int choose = 1;
        Scanner input = new Scanner(System.in);

        /*
         * 初始化三个图书
         */
        bookname[0] = "Java基础教程";
        bookstate[0] = 0;
        bookdate[0] = 1;
        bookcount[0] = 12;

        bookname[1] = "数据库技术";
        bookstate[1] = 1;
        bookcount[1] = 10;

        bookname[2] = "人月神话";
        bookstate[2] = 0;
        bookcount[2] = 20;

        do {
            /*
             * 开始菜单
             */
            System.out.println("欢迎来到天道图书馆");
            System.out.println("_φ(❐_❐✧ 人丑就要多读书_φ(❐_❐✧ ");
            System.out.println("1 . 新增图书");
            System.out.println("2 . 查看图书");
            System.out.println("3 . 删除图书");
            System.out.println("4 . 借出图书");
            System.out.println("5 . 归还图书");
            System.out.println("6 . 退出图书");
            System.out.println("_φ(❐_❐✧ 人丑就要多读书_φ(❐_❐✧ ");
            System.out.println("请选择 ： ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    /*
                     * 新增图书
                     */
                    System.out.println("---> 新增图书\n");
                    System.out.print("请输入图书名称： ");
                    String name = input.next();
                    if (bookname[5] != null) {
                        System.out.println("新增《" + name + "》失败！货架已满！");
                        break;
                    }
                    for (int i = 0; i < bookname.length; i++) { // 循环遍历bookname数组
                        if (bookname[i] == null) { // 查询最后一个空位置插入
                            bookname[i] = name;
                            bookstate[i] = 1;// 置新增的图书可借状态
                            bookcount[i] = 0;// 置借出次数为0
                            System.out.println("新增《" + name + "》成功！");
                            break;
                        }
                    }
                    System.out.println("**************************");
                    break; // 跳出switch循环
                case 2:
                    /*
                     * 查看图书
                     */
                    System.out.println("--->> 查看图书\n");
                    System.out.println("序号\t状态\t名称\t\t借出日期\t借出次数");
                    for (int i = 0; i < bookname.length; i++) {
                        if (bookname[i] == null) {
                            break;
                        } else if (bookstate[i] == 0) {
                            System.out.println((i + 1) + "\t已借出\t" + "<<" + bookname[i] + ">>\t" + bookdate[i] + "日\t"+ bookcount[i] + "次");
                        } else if (bookstate[i] == 1) { // bookstate[i]为1则说明该图书可借
                            System.out
                                    .println((i + 1) + "\t可 借\t" + "<<" + bookname[i] + ">>" + "\t\t" + bookcount[i] + "次");
                        }
                    }
                    break;
                case 3:
                    /*
                     * 删除图书
                     */
                    boolean flag = false;// 标识删除成功与否
                    System.out.println("---> 删除图书\n");
                    System.out.print("请输入图书名称： ");
                    name = input.next();
                    // 遍历数组，查找匹配信息
                    for (int i = 0; i < bookname.length; i++) {
                        // 查找到，每个元素前移一位
                        if (bookname[i] != null && bookname[i].equalsIgnoreCase(name) && bookstate[i] == 1) {
                            // equalsIgnoreCase方法判断字符串是否相同且忽略大小写
                            int j = i;
                            while (bookname[j + 1] != null) { // 遍历需删除的元素之后的非空元素
                                bookname[j] = bookname[j + 1];
                                bookstate[j] = bookstate[j + 1];
                                bookdate[j] = bookdate[j + 1];
                                bookcount[j] = bookcount[j + 1];
                                j++;
                            }
                            // 最后一个不为空的元素置空
                            bookname[j] = null;
                            bookdate[j] = 0;
                            System.out.println("删除《" + name + "》成功！");
                            flag = true;// 表示删除成功
                            break;
                        } else if (bookname[i] != null && bookname[i].equalsIgnoreCase(name) && bookstate[i] == 0) {
                            System.out.println("《" + name + "》为借出状态，不能删除！");
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) { // 若flag不为true则说明用户输入的名称在bookname数组中没有匹配成功
                        System.out.println("没有找到匹配信息！");
                    }
                    System.out.println("**************************");
                    break;
                case 4:
                    /*
                     * 借出图书
                     */
                    System.out.println("---> 借出图书\n");
                    System.out.print("请输入图书名称： ");
                    String want = input.next(); // 要借出的图书名称
                    for (int i = 0; i < bookname.length; i++) {
                        if (bookname[i] == null) { // 无匹配
                            System.out.println("没有找到匹配信息！");
                            break;
                        } else if (bookname[i].equals(want) && bookstate[i] == 1) { // 找到匹配可借
                            bookstate[i] = 0; // 将此图书置于借出状态
                            System.out.print("请输入借出日期：");
                            bookdate[i] = input.nextInt();
                            while (bookdate[i] < 1 || bookdate[i] > 31) { // 一个月只有31天则需要数据校验
                                System.out.print("必须输入大于等于1且小于等于31的数字，请重新输入：");
                                bookdate[i] = input.nextInt();
                            }
                            System.out.println("借出《" + want + "》成功!");
                            bookcount[i]++;
                            break;
                        } else if (bookname[i].equals(want) && bookstate[i] == 0) { // 找到匹配已被借出
                            System.out.println("《" + want + "》已被借出！");
                            break;
                        }
                    }
                    System.out.println("**************************");
                    break;
                case 5:
                    /*
                     * 归还图书并计算租金
                     */
                    System.out.println("---> 归还图书\n");
                    int charge;// 租金
                    System.out.print("请输入图书名称： ");
                    want = input.next();
                    for (int i = 0; i < bookname.length; i++) {
                        if (bookname[i] == null) { // 无匹配
                            System.out.println("没有找到匹配信息！");
                            break;
                        } else if (bookname[i].equals(want) && bookstate[i] == 0) { // 找到匹配
                            bookstate[i] = 1;
                            System.out.print("请输入归还日期：");

                            int rebookdate = input.nextInt();
                            while (rebookdate < bookdate[i] || rebookdate > 31) { // 归还日期的数据校验
                                if (rebookdate < bookdate[i]) {
                                    System.out.print("归还日期不能小于借出日期,请重新输入：");
                                } else {
                                    System.out.print("一个月只有31天，请重新输入：");
                                }
                                rebookdate = input.nextInt();
                            }
                            charge = rebookdate - bookdate[i];
                            System.out.println("\n归还《" + want + "》成功!");
                            System.out.println("借出日期为：" + bookdate[i] + "日");
                            System.out.println("归还日期为：" + rebookdate + "日");
                            System.out.println("应付租金（元）：" + charge);
                            break;
                        } else if (bookname[i].equals(want) && bookstate[i] == 1) { // 找到匹配但没有借出
                            System.out.println("该图书没有被借出！无法进行归还操作。");
                            break;
                        }
                    }
                    System.out.println("**************************");
                    break;
                case 6:
                    choose = 2; // 用户选择退出
                    break;
                default:
                    System.out.println("非法操作");
                    choose = 2; // 用户没有输入1到6的整形数据则属于非法操作直接退出程序
                    break;
            }
            if (choose != 2) {// 如果为2则是用户选择了退出或者是非法操作
                System.out.println("输入0返回 ");
                int back = input.nextInt();
                if (back != 0) {// 如果用户没选择0则为非法操作
                    System.out.println("非法操作");
                    choose = 2;
                }
            }

        } while (choose == 1); // 判断用户择退出还是返回
        System.out.print("谢谢使用");

    }
}

