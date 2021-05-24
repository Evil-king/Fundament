package com.hwq.fundament.JavaDataStructure.recursion;

/**
 * @Auther: Administrator
 * @Date: 2020/2/28 0028 21:34
 * @Description: 猴子吃桃子问题
 * <p>
 * 猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个，
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃前一天剩下的一半零一个。
 * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘多少个桃子？
 */
public class EatPeach {
    public static void main(String[] args) {
        int day = 9;
        int peach = peach(day);
        System.out.println("第"+day+"天的桃子数：" + peach);
    }

    private static int peach(int n) {
        if (n > 10 || n < 1) {
            System.out.println("天数不正确");
            return 0;
        }
        if (n == 10) {
            return 1;
        }
        return (peach(n + 1) + 1) * 2;
    }
}
