package com.hwq.fundament.JavaDataStructure.search;

/**
 * @Auther: Administrator
 * @Date: 2020/2/21 0021 11:59
 * @Description: 插值查找算法
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int valueSearch = insertValueSearch(arr, 0, arr.length-1, 100);
        System.out.println("valueSearch=" + valueSearch);
    }

    public static int insertValueSearch(int arr[], int left, int right, int findVal) {

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midIndex = arr[mid];

        //先判断查不到的情况 注意findVal < arr[0] || findVal > arr[arr.length-1]
        //这个判断必须加上 否则mid会出现数组越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        if (findVal > midIndex) { //应该向右边递归
            return insertValueSearch(arr, left, mid + 1, findVal);
        } else if (findVal < midIndex) { //应该向左边递归
            return insertValueSearch(arr, mid - 1, right, findVal);
        } else {
            return mid;
        }
    }
}
