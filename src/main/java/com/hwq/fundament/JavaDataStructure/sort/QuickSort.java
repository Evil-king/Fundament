package com.hwq.fundament.JavaDataStructure.sort;

/**
 * @Auther: Administrator
 * @Date: 2020/3/7 0007 17:31
 * @Description:快速排序
 * 快速排序是对冒泡排序的一种改进，基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据要小，然后再按此方法对这两部分数据分别进行
 * 快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        //while循环的目的是让比pivot 值肖的放到左边
        //比pivot 值大的放到右边
        while (l < r) {
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l>=r 说明pivot 左右两边的值，已经按照左边全部是小于等于pivot值 右边全部是大于等于pivot的值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[r] = temp;
            arr[r] = temp;

            //如果交换完 发现这个arr[l] == pivot值相等 r--。前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完 发现这个arr[r] == pivot值相等 r--。前移
            if (arr[l] == pivot) {
                r -= 1;
            }
        }
        //如果 l==r 必须l++,r--,否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
