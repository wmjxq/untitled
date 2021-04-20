package edu.xcdq;

import java.lang.reflect.Array;
import java.util.Arrays;

// 6 concat  拼接函数
    // 7 indexOf  第一次出现的下标
    // 8 lastIndexOf  最后一次出现的下标
    // 9 substring(开始位置)  截取元素
    // 10 substring(2,4)  按[2,4)截取元素
    // 11 trim() 去掉字符串前后的空格
public class demo04 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        System.out.println(s1+s2);                  //  helloworld
        System.out.println(s1.concat(s2));          //  helloworld
        System.out.println(s2.concat(s1));          //  helloworld

        System.out.println(s1.indexOf("l"));  // 2  从0开始计数
        System.out.println(s1.lastIndexOf("l"));  // 3  从0开始计数


        System.out.println(s1.substring(2));//ll0
        System.out.println(s2.substring(2,4));//[2,4) 包含2，不包含4 位置的元素

        String s3 = "   haha  hehe heihei";
        System.out.println(s3);
        System.out.println(s3.trim());
        
        
        String geci = "长亭外 古道边 芳草碧连天 晚风扶柳笛声残";
        String[]s = geci.split("");
        for(int i = 0;i<s.length;i++){
            System.out.println(s[i]);

        }
    }
}
