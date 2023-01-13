package com.xiangfei.demo;

/**
 * @Author: xiangfei
 * @CreateTime: 2023/1/5 17:59
 */
//单例模式
public class Danli {

    private Danli() {
    }

    private static Danli danli = new Danli();

    private static Danli getInstance() {
        return danli;
    }

    //斐波那契数列
    public static void main(String[] args) {
        int a = 1, b = 1, c = 0;
        System.out.println("斐波那契数列前20项为：");
        System.out.println(a + "\t" );
        System.out.println(b + "\t");
        for (int i = 0; i <= 18; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.println(c + "\t");
//            if ((i + 2) % 5 == 0) {
//                System.out.println();
//            }
        }
    }
}
