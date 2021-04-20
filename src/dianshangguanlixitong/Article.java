package dianshangguanlixitong;

public class Article {
//    第二：商品类(仓库类）
        public String name;      // 商品名称
        public int amount ;      // 库存
        public double price;     // 单价
        public int number;       // 售出数量

        public void print(int index ) { // 打印：为了方便查看商品类的详情
            System.out.println(index + "\t" + name + "\t" + amount + "\t" + price + " \t" + number); // 商品的封装
        }
        public void setArticle(String mingzi,int kucun,double danjia,int shouchu) {
            name = mingzi;
            amount = kucun;
            price = danjia;
            number = shouchu;
        }
}
