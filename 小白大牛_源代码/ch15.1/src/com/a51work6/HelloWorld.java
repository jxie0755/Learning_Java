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

        //day工作日变量
        int day = WeekDays.FRIDAY;

        switch (day) {
            case WeekDays.MONDAY:
                System.out.println("星期一");
                break;
            case WeekDays.TUESDAY:
                System.out.println("星期二");
                break;
            case WeekDays.WEDNESDAY:
                System.out.println("星期三");
                break;
            case WeekDays.THURSDAY:
                System.out.println("星期四");
                break;
            case WeekDays.FRIDAY:
                System.out.println("星期五");
        }
    }
}
