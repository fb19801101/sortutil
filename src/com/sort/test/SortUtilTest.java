package com.sort.test;

import com.sort.util.Reminder;
import com.sort.util.RunTimeUtil;
import com.sort.util.SortUtil;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-28 22:48
 */
public class SortUtilTest {
    public static void main(String[] args) {
        int arr[] = {10, 15, 33, 12, 255, 101, 98, 201, 300, 14};
        SortUtil.quick_Sort(arr, 0, 9, true);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        int[] arr1 = new int[10000000];
        for(int i=0; i<arr1.length; i++) {
            arr1[i] = i;
        }

        RunTimeUtil rt = new RunTimeUtil();
        int value = 100000;
        int len = arr1.length-1;
        int index = SortUtil.binary_search(arr1, value);
        System.out.println("value: "+value+"  的索引为： "+index);
        new RunTimeUtil();
        new Reminder(2);
        rt.outTime();
    }
}
