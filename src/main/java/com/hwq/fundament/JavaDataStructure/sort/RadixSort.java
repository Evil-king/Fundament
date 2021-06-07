package com.hwq.fundament.JavaDataStructure.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }


    public static void radixSort(int[] arr) {

        //定义一个二维数组，表示有10个桶，每个桶就是一个一维数组
        //说明
        //1、二维数组包含10个一维数组
        //2、为了防止在放入数的时候，数据溢出，则每个一维数组(桶),大小定义为arr.length
        //3、明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际存放了多少个数据，我们定义一个一维数组来记录各个桶每次放入的数据个数
        //可以这样理解
        //比如：bucketElementCounts[0],记录的就是 bucket[0]桶放入的数据个数
        int[] bucketElementCounts = new int[10];


        //得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //针对每个元素对应的位数进行排序处理，第一次是个位，第二次是十位，第三次是百位
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素对应的的值
                int digitElement = arr[j] / n % 10;
                //放入对应的桶中
                bucket[digitElement][bucketElementCounts[digitElement]] = arr[j];
                bucketElementCounts[digitElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) { //遍历10个桶
                //只获取桶中有数据的
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即一维数组,放入到原始数组中
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个bucketElementCounts[k]中的元素清理
                bucketElementCounts[k] = 0;
            }
            System.out.println("第"+(i+1)+"轮，对个位的排序处理 arr = " + Arrays.toString(arr));
        }


        /**
         //第一轮(针对每个元素的个位进行排序)
         for (int i = 0; i < arr.length; i++) {
         //取出每个数的个位数的值
         int digitElement = arr[i] % 10;
         //放入对应的桶中
         bucket[digitElement][bucketElementCounts[digitElement]] = arr[i];
         bucketElementCounts[digitElement]++;
         }
         //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
         int index = 0;
         for (int k = 0; k < bucketElementCounts.length; k++) { //遍历10个桶
         //只获取桶中有数据的
         if (bucketElementCounts[k] != 0) {
         //循环该桶即一维数组,放入到原始数组中
         for (int l = 0; l < bucketElementCounts[k]; l++) {
         arr[index++] = bucket[k][l];
         }
         }
         //第一轮处理后，需要将每个bucketElementCounts[k]中的元素清理
         bucketElementCounts[k] = 0;
         }
         System.out.println("第1轮，对个位的排序处理 arr = " + Arrays.toString(arr));
         //==================================================
         //第二轮(针对每个元素的十位进行排序)
         for (int i = 0; i < arr.length; i++) {
         //取出每个数的十位数的值
         int digitElement = arr[i] / 10 % 10;
         //放入对应的桶中
         bucket[digitElement][bucketElementCounts[digitElement]] = arr[i];
         bucketElementCounts[digitElement]++;
         }
         //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
         index = 0;
         for (int k = 0; k < bucketElementCounts.length; k++) { //遍历10个桶
         //只获取桶中有数据的
         if (bucketElementCounts[k] != 0) {
         //循环该桶即一维数组,放入到原始数组中
         for (int l = 0; l < bucketElementCounts[k]; l++) {
         arr[index++] = bucket[k][l];
         }
         }
         //第二轮处理后，需要将每个bucketElementCounts[k]中的元素清理
         bucketElementCounts[k] = 0;
         }
         System.out.println("第2轮，对个位的排序处理 arr = " + Arrays.toString(arr));
         //==========================================
         //第三轮(针对每个元素的百位进行排序)
         for (int i = 0; i < arr.length; i++) {
         //取出每个数的百位数的值
         int digitElement = arr[i] / 100 % 10;
         //放入对应的桶中
         bucket[digitElement][bucketElementCounts[digitElement]] = arr[i];
         bucketElementCounts[digitElement]++;
         }
         //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
         index = 0;
         for (int k = 0; k < bucketElementCounts.length; k++) { //遍历10个桶
         //只获取桶中有数据的
         if (bucketElementCounts[k] != 0) {
         //循环该桶即一维数组,放入到原始数组中
         for (int l = 0; l < bucketElementCounts[k]; l++) {
         arr[index++] = bucket[k][l];
         }
         }
         }
         System.out.println("第3轮，对个位的排序处理 arr = " + Arrays.toString(arr));
         **/
    }
}


