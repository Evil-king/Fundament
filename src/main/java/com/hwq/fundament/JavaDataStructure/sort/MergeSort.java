package com.hwq.fundament.JavaDataStructure.sort;

/**
 * 归并排序是利用归并的思想实现的排序方法，该算法采用经典的分治策略成一些小的问题然后递归求解，而治的阶段则将分的阶段得到的各方案
 * 修补在一起，即分而治之
 */
public class MergeSort {

    /**
     * 合并的方法
     *
     * @param arr   排序的原始数组
     * @param left  左右有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid + 1; //初始化j，右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引

        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到temp数组
            //然后 t++,i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { //反之，将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //(二)
        //把剩余数据的一边数据依次全部填充到temp
        while (i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) { //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        //第一次合并 tempLeft = 0，right = 1 最后一次 tempLeft = 0，right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
