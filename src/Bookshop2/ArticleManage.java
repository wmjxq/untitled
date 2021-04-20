package Bookshop2;

import java.util.Scanner;

/**
 * @author weimengjie
 * @date 2021/4/7 14:39
 */
public class ArticleManage {
    ArticleSet articleSet = new ArticleSet();

    public void initial () {
        Article xiaomi11 = new Article();
        xiaomi11.setArticle("小米11" , 1999,100,1);

        Article xiaomi11Pro = new Article();
        xiaomi11Pro.setArticle("小米11pro" ,2999 , 200, 0);

        Article xiaomiUltra = new Article();
        xiaomiUltra.setArticle("小米Ultra" ,3999 , 300,2);

        articleSet.articles[0] = xiaomi11;
        articleSet.articles[1] = xiaomi11Pro;
        articleSet.articles[2] = xiaomiUltra;

    }
    public void startMenu(){
        boolean flag = true;
        do {
            System.out.println("**********************");
            System.out.println("1 查看商品信息");
            System.out.println("2 新增商品信息");
            System.out.println("3 删除商品信息");
            System.out.println("4 卖出商品信息");
            System.out.println("5 销售排行榜");
            System.out.println("6 退出");

            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你要执行的功能编号：");
            int funNO  = scanner.nextInt();
            switch (funNO) {
                case 1 :
                { System.out.println("1 查看商品信息"); chakan(); }
                case 2 : { System.out.println("2 新增商品信息"); add(); }
                case 3 : { System.out.println("3 删除商品信息"); delete(); }
                case 4 : { System.out.println("4 卖出商品信息"); sell();}
                case 5 : { System.out.println("5 销售排行榜");  paihangbang(); }
                case 6 : { System.out.println("6 退出"); flag = false; exit();}
                break;
                default:
            }
        }while ( flag );
    }

    public void exit() {
        System.out.println("谢谢，感谢使用! 已经退出");
    }

    public void paihangbang() {
        // 排序 （冒泡排序）
        for ( int i = 0 ; i < articleSet.articles.length - 1  ; i ++ ) {
            for ( int j = 0 ; j < articleSet.articles.length - i -1 ; j ++ ) {
                // 如果当前元素的值比后面的元素值小 那么和后面的元素交换位置
                if (articleSet.articles[j] != null && articleSet.articles[j+1] != null ){
                    if (  articleSet.articles[j].number < articleSet.articles[j+1].number ) {
                        // 交换位置
                        Article tempArticle = articleSet.articles[j];
                        articleSet.articles[j] = articleSet.articles[j+1] ;
                        articleSet.articles[j+1] = tempArticle;
                    }
                }
            }
        }
        // 打印排行榜
        System.out.println("**********排行榜***********");
        System.out.println("名次 \t 销售数量 \t 商品名称");
        for (int i = 0; i < articleSet.articles.length; i++) {
            if ( articleSet.articles[i] != null ) {
                System.out.println( (i+1)  + "\t" + articleSet.articles[i].number +"\t"+ articleSet.articles[i].name );
            }
        }

    }


    public void sell() {
        System.out.println("请输入你要售卖的商品名称：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < articleSet.articles.length; i++) {
            if ( (articleSet.articles[i].name).equals(name) ) {
                System.out.println("请输入你要售卖的数量：");
                int shoumai = scanner.nextInt();
                if ( shoumai < articleSet.articles[i].amount ) {
                    articleSet.articles[i].amount = articleSet.articles[i].amount - shoumai ;
                    articleSet.articles[i].number = articleSet.articles[i].number + shoumai ;
                }
                System.out.println("售卖成功");
                break;
            }
        }
    }

    public void delete() {
        System.out.println("请输入你要删除的商品编号：");
        Scanner scanner = new Scanner(System.in);
        int delNo  = scanner.nextInt();
        for (int i = 0; i < articleSet.articles.length; i++) {
            if ( articleSet.articles[i] != null && (i+1) == delNo ) {   //数组中的元素存在 && 找到要删除的元素i
                int j = i ;
                while ( articleSet.articles[j+1] != null ) { // 要移动的元素后一个位置不为空 ，执行以下操作
                    articleSet.articles[j] = articleSet.articles[j+1] ; // 把后面元素的值覆盖在前面的元素上
                    j ++ ;
                }
                articleSet.articles[i] = null; // 最后一个元素手动修改为空
                System.out.println("删除成功！");
                break;
            }
        }
    }

    public void chakan(){
        System.out.println("编号 \t 名称 \t 单价 \t 库存 \t 已售");
        for (int i = 0; i < articleSet.articles.length; i++) {
            if ( articleSet.articles[i] != null ) {
                articleSet.articles[i].print(i+1);
            }
        }
    }

    public void add() {
        System.out.println("请输入商品名称：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("输入价格：");
        double price = scanner.nextDouble();
        System.out.println("输入库存：");
        int cukun = scanner.nextInt();
        System.out.println("已卖出数量：");
        int maichu = scanner.nextInt();

        Article newArticle = new Article();
        newArticle.setArticle(name , price , cukun , maichu) ;

        for (int i = 0; i < articleSet.articles.length; i++) {
            if ( articleSet.articles[i] == null ) {
                articleSet.articles[i] = newArticle;
                break; // 只添加数组中的第一个空位置，后续的空位直接跳过，中断循环
            }
        }
    }


}
