package com.hwq.fundament.JavaDataStructure.recursion;

/**
 * @Auther: Administrator
 * @Date: 2020/2/28 0028 19:53
 * @Description: 递归中8皇后问题
 * 理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，
 * 用一个一维数组即可解决问题. arr[8] = {0, 4, 7, 5, 2, 6, 1, 3}
 * 对应arr 下标 表示第几行，即第几个皇后，arr[i] = val , val 表示第i+1个皇后，放在第i+1行的第val+1列
 *
 */
public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max  = 8;
    //定义数组array 保存皇后放置位置的结果 比如arr = {0,4,7,5,2,6,13}
    int[] array = new int[8];
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        queue8.print();
    }

    //编写一个方法，放置第n个皇后
    private void check(int n){
        if(n == max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //一行一行的放置n
            array[n] = i;
            //调用judge方法判断是否有冲突
            if(judge(n)){
                //如果没有冲突 这下一行 直到max为止 结束
                check(n+1);
            }
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //array[i] == array[n]是判断第n个皇后和前面n-1个皇后在同一列
            //Math.abs(n-i) == Math.abs(array[n] - array[i] 判断第n个皇后是否和第i个皇后是否在同一斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
            //没有必要判断是否在同一行，因为n每次都是递增的 其中n就是代表行数
        }
        return true;
    }



    //写一个方法，可以将皇后摆放的位置输出
    private void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"");
        }
        System.out.println();
    }
}
