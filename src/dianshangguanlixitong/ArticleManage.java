package dianshangguanlixitong;

import java.util.Scanner;
//第三：代码类
public class ArticleManage {
    /*
     * 商品管理类
     * */
    //创建一个实体的仓库对象并初始化
    dianshangguanlixitong.ArticleSet articleSet = new dianshangguanlixitong.ArticleSet();

    //初始化仓库，放入其实商品
    public void initial() {
        Article xiaomi11 = new Article();
        xiaomi11.setArticle("小米11", 30, 1999, 0);

        Article xiaomi11pro = new Article();
        xiaomi11pro.setArticle("小米11Pro", 40, 2999, 0);

        Article xiaomiUltra = new Article();
        xiaomiUltra.setArticle("小米增强版", 50, 3999, 0);

        articleSet.articles[0] = xiaomi11;
        articleSet.articles[1] = xiaomi11pro;
        articleSet.articles[2] = xiaomiUltra;

    }

    public void startMenu() {
        boolean flag = true;
        do {
            System.out.println("**********************************");
            System.out.println("1 查看商品信息");
            System.out.println("2 新增商品信息");
            System.out.println("3 删除商品信息");
            System.out.println("4 卖出商品");
            System.out.println("5 排行榜");
            System.out.println("6 退出");
            System.out.println("**********************************");
            System.out.println("请输入功能编号：");
            Scanner scanner = new Scanner(System.in);
            int gong = scanner.nextInt();
            switch (gong) {
                case 1:
                    System.out.println("查看商品信息");
                    chakan();
                    break;
                case 2:
                    System.out.println(" 新增商品信息");
                    add();
                    break;
                case 3:
                    System.out.println("删除商品信息");
                    delete();
                    break;
                case 4:
                    System.out.println("卖出商品");
                    sell();
                    break;
                case 5:
                    System.out.println("排行榜");
                    leaderboard();
                    break;
                case 6:
                    System.out.println("退出");
                    flag = false;
                default:
                    System.out.println("谢谢使用！");
                    break;
            }
        } while (flag);
    }
    //  排行榜
    public void leaderboard(){
        int count = 0 ; //统计原始数据组使用的长度
        for (int i = 0; i<articleSet.articles.length; i++){
            if(articleSet.articles[i]!=null){
                count ++;
            }
        }
        //根据使用长度临时新建一个数组，这个数组元素存满
        Article[] newTemp = new Article[count];
        // 把旧数组中的元素全部拷贝到新数组中，新数组装满元素
        for (int i = 0; i<count; i++){
            newTemp[i] = articleSet.articles[i];
        }
        // 排序  (冒泡排序)
        for (int i = 0; i<newTemp.length-1; i++){  // 让所有元素参与排序
            for (int j = 0; j<newTemp.length-i-1; j++){  // 让当前元素和它后面的元素对比
                if (newTemp[j+1]!=null){  //保证下一个要对比的元素存在
                    if (newTemp[j].number<newTemp[j+1].number){
                        //   两个元素交换位置，需要借助第三方临时变量做存储
                        Article temp = newTemp[i];
                        newTemp[j]  = newTemp[j+1];
                        newTemp[j+1] = temp;
                    }
                }
            }
        }
        //显示名次
        System.out.println("名次： \t 销售数量 \t 商品名称");
        for (int i = 0; i<newTemp.length;i++){
            System.out.println((i+1)+"\t"+newTemp[i].number+"\t"+newTemp[i].name);
        }
    }


    public void sell() {
        boolean flag = true;
        System.out.println("请输入你要卖出商品的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < articleSet.articles.length; i++) {
            if (articleSet.articles[i] != null && articleSet.articles[i].name.equals(name)) {
                System.out.println("请输入卖出的数量：");
                int maichu = scanner.nextInt();
                if (maichu < articleSet.articles[i].amount) { //卖出数量<库存数
                    // 新库存 = 旧库存 -卖出数量
                    articleSet.articles[i].amount = articleSet.articles[i].amount - maichu;
                    // 新售出 = 旧售出 -卖出数量
                    articleSet.articles[i].amount = articleSet.articles[i].number + maichu;
                    flag = true;
                } else {
                    flag = false;
                    System.out.println("库存不够");
                }
                break; // 找到对应的位置，已经完成了修改，终断循环
            } else {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("卖出成功");
        } else {
            System.out.println("卖出失败");
        }
    }



    public void chakan() {
        System.out.println("编号 \t 名称 \t 库存 \t 单价 \t 卖出数量");
        for (int i = 0; i < articleSet.articles.length; i++) {
            if (articleSet.articles[i] != null) {
                articleSet.articles[i].print(i + 1);
            }
        }
    }

    public void add() {
        // 接受用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品名字：");
        String name = scanner.next();
        System.out.println("请输入商品价格：");
        double price = scanner.nextDouble();
        System.out.println("库存：");
        int kucun = scanner.nextInt();
        System.out.println("售出数量：");
        int number = scanner.nextInt();
        //  把接受到的数据封装到对象中
        Article newArticle = new Article();
        newArticle.setArticle(name, kucun, price, number);
        for (int i = 0; i < articleSet.articles.length; i++) {
            if (articleSet.articles[i] == null) {  // 从前往后遍历数组，找到第一个没有元素的位置
                articleSet.articles[i] = newArticle;  // 找到空位置，把新商品存入
                break;   //后续的位置不加入
            }
        }
    }
    public void delete() {
        boolean flag = true;
        System.out.println("删除的编号：");
        Scanner scanner = new Scanner(System.in);
        int delNo = scanner.nextInt();
        for (int i = 0; i < articleSet.articles.length; i++) {
            if (delNo == (i + 1) && articleSet.articles[i] != null) {
                int j = i;//备份要删除元素下标
                while (articleSet.articles[j + 1] != null) {
                    articleSet.articles[j] = articleSet.articles[j + 1];
                    j++;
                }
                articleSet.articles[j] = null;
                flag = true;
                break; //操作完成直接终断for循环，后面的null元素无需操作
            } else {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败!");
        }

    }
}
