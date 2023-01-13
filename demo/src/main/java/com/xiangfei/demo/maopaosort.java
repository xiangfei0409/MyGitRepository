package com.xiangfei.demo;

/**
 * @Author: xiangfei
 * @CreateTime: 2023/1/5 17:39
 */
public class maopaosort {

    //冒泡排序
    public static void main(String[] args) {
        int temp;
        int[]a = {56,8,3,99,86,44,785,35};
        for(int i=0; i < a.length-1; i++){
            for(int j = 0; j < a.length-1-i; j++){
                if(a[j] > a[j+1]){
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int aa : a){
            System.out.println(aa);
        }
    }
}
