/*
 * Created by 智捷课堂
 * 本书网站：http://www.zhijieketang.com/group/5
 * 智捷课堂在线课堂：www.zhijieketang.com
 * 智捷课堂微信公共号：zhijieketang
 * 邮箱：eorient@sina.com
 * Java读者服务QQ群：547370999
 *
 * 买《Java从小白到大牛》纸质版图书，送配套视频
 *
 * 【配套电子书】网址：
 *       图灵社区：
 *       http://www.ituring.com.cn/book/2480
 *       百度阅读：
 *       https://yuedu.baidu.com/ebook/7c1499987e192279168884868762caaedd33ba00
 */


//HelloWorld.java文件
package com.a51work6;

public class HelloWorld {

    public static void main(String[] args) {

        int n1 = 10;
        int n2 = 5;

        // 实现加法计算Calculable对象
        Calculable f1 = calculate('+');
        // 实现减法计算Calculable对象
        Calculable f2 = calculate('-');

        // 调用calculateInt方法进行加法计算
        System.out.printf("%d + %d = %d \n", n1, n2, f1.calculateInt(n1, n2));
        // 调用calculateInt方法进行减法计算
        System.out.printf("%d - %d = %d \n", n1, n2, f2.calculateInt(n1, n2));
    }

    /**
     * 通过操作符，进行计算
     *
     * @param opr 操作符
     * @return 实现Calculable接口对象
     */
    public static Calculable calculate(char opr) {

        Calculable result;

        if (opr == '+') {
            // 匿名内部类实现Calculable接口
            result = new Calculable() {
                // 实现加法运算
                @Override
                public int calculateInt(int a, int b) {
                    return a + b;
                }
            };
        } else {
            // 匿名内部类实现Calculable接口
            result = new Calculable() {
                // 实现减法运算
                @Override
                public int calculateInt(int a, int b) {
                    return a - b;
                }
            };
        }

        return result;
    }
}
