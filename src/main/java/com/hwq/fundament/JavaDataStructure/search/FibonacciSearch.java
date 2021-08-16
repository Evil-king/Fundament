package com.hwq.fundament.JavaDataStructure.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.printf("index=" + fibSearch(arr, 12));
    }

    //因为后面我们mid = low+F(k-1)-1,需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
    //斐递归的方式创建一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //编写斐波那契查找算法（使用非递归的方法）

    /**
     * @param a   数组
     * @param key 我嫩需要查找的关键码(值)
     * @return 返回对应的下标，如果没有返回-1
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那契分割值的下标
        int mid = 0;
        int[] f = fib();//获取到斐波那契数列
        //获取到斐波那契分割值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]的值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组并指向a
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //实际上需要使用a数组最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        //使用while来循环处理，找到我们的key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) { //我们应该继续向数组的前面查找(左边)
                high = mid - 1;
                //为什么是k--
                //说明：1、全部元素 = 前面的元素+后边元素 2、f[k]=f[k-1]+f[k-2]
                //因为 前面有f[k-1]个元素，所以可以继续拆分f[k-1]= f[k-2]+f[k-3]
                //即在f[k-1] 的前面继续查找 k--
                //即下次循环mid = f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) { //我们应该继续向数组的后面查找(右边)
                low = mid + 1;
                //为什么是k--
                //说明：1、全部元素 = 前面的元素+后边元素 2、f[k]=f[k-1]+f[k-2]
                //因为 后面有f[k-2]个元素，所以可以继续拆分f[k-1]= f[k-3]+f[k-4]
                //即在f[k-2] 的前面继续查找 k-=2
                //即下次循环mid = f[k-1-2]-1
                k -= 2;
            } else { //找到了
                //需要确定返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
