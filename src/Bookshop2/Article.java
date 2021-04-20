package Bookshop2;
/**
 * @author weimengjie
 * @date 2021/4/7 14:34
 */
public class Article {
    public String name;
    public double price;
    public int amount;
    public int number;

    public void print(int index ){
        System.out.println(index +"\t\t "+ name +"\t" + price + "\t" + amount +"\t" + number );
    }

    public void setArticle(String mingzi , double danjia , int kucun , int shouchu) {
        name = mingzi;
        price = danjia;
        amount = kucun;
        number = shouchu;
    }



}
