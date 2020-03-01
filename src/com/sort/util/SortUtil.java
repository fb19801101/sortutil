package com.sort.util;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-28 16:48
 */
public class SortUtil {
    /**
     * 冒泡排序(BubbleSort)
     * 基本思想：
     * 两个数比较大小，较大的数下沉，较小的数冒起来。
     * 比较相邻的两个数据，如果第二个数小，就交换位置。
     * 从后向前两两比较，一直到比较最前两个数据。最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
     * 继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
     *
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(n2)。
     *
     * @param arr
     * @param asc
     */
    public static void bubble_sort(int[] arr, boolean asc) {
        int temp;//临时变量
        boolean flag;//是否交换的标志
        for (int i = 0; i < arr.length - 1; i++) {   //表示趟数，一共 arr.length-1 次
            // 每次遍历标志位都要先置为false，才能判断后面的元素是否发生了交换
            flag = false;
            for (int j = arr.length - 1; j > i; j--) { //选出该趟排序的最大值往后移动
                if (asc) {
                    if (arr[j] < arr[j - 1]) {
                        temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                        flag = true;    //只要有发生了交换，flag就置为true
                    }
                } else {
                    if (arr[j] > arr[j - 1]) {
                        temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                        flag = true;    //只要有发生了交换，flag就置为true
                    }
                }
            }
            // 判断标志位是否为false，如果为false，说明后面的元素已经有序，就直接return
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 选择排序(SelctionSort)
     * 基本思想：
     * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     *
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(n2)。
     *
     * @param arr
     * @param asc
     */
    public static void select_sort(int[] arr, boolean asc) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (asc) {
                    if (arr[j] < arr[index]) {
                        index = j;
                    }
                } else {
                    if (arr[j] > arr[index]) {
                        index = j;
                    }
                }
            }

            if (index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    /**
     * 插入排序(Insertion Sort)
     * 基本思想：
     * 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，
     * 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     *
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(n2)。
     *
     * @param arr
     * @param asc
     */
    public static void insert_sort(int[] arr, boolean asc) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (asc) {
                    if (arr[j] < arr[j - 1]) {
                        temp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    } else { //不需要交换
                        break;
                    }
                } else {
                    if (arr[j] > arr[j - 1]) {
                        temp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    } else { //不需要交换
                        break;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序(Shell Sort)
     * 基本思想：
     * 在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序。
     * 然后逐渐将增量减小,并重复上述过程。直至增量为1,此时数据序列基本有序,最后进行插入排序。
     *
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(n1.5)。
     *
     * @param arr
     * @param asc
     */
    public static void shell_sort(int[] arr, boolean asc) {
        int temp = 0;
        int key = arr.length;

        while (true) {
            key = key / 2;
            for (int k = 0; k < key; k++) {    //根据增量分为若干子序列
                for (int i = k + key; i < arr.length; i += key) {
                    for (int j = i; j > k; j -= key) {
                        if (asc) {
                            if (arr[j] < arr[j - key]) {
                                temp = arr[j - key];
                                arr[j - key] = arr[j];
                                arr[j] = temp;
                            } else {
                                break;
                            }
                        } else {
                            if (arr[j] > arr[j - key]) {
                                temp = arr[j - key];
                                arr[j - key] = arr[j];
                                arr[j] = temp;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

            if (key == 1) {
                break;
            }
        }
    }

    /**
     * 快速排序(Quicksort)
     * 基本思想：
     * 先从数列中取出一个数作为key值；
     * 将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
     * 对左右两个小数列重复第二步，直至各区间只有1个数。
     *
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(N*logN)。
     *
     * @param arr
     * @param left
     * @param right
     * @param asc
     */
    public static void quick_Sort(int[] arr, int left, int right, boolean asc) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int key = arr[left];//选择第一个数为key

        while (i < j) {
            if (asc) {
                while (i < j && arr[j] >= key) {//从右向左找第一个小于key的值
                    j--;
                }

                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && arr[i] < key) {//从左向右找第一个大于key的值
                    i++;
                }

                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            } else {
                while (i < j && arr[j] <= key) {//从右向左找第一个小于key的值
                    j--;
                }

                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && arr[i] > key) {//从左向右找第一个大于key的值
                    i++;
                }

                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
        }

        //i == j
        arr[i] = key;
        quick_Sort(arr, left, i - 1, asc);//递归调用
        quick_Sort(arr, i + 1, right, asc);//递归调用
    }

    /**
     * 归并排序(Merge Sort)
     * 基本思想：
     * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法的一个非常典型的应用。
     * 首先考虑下如何将2个有序数列合并。这个非常简单，只要从比较2个数列的第一个数，谁小就先取谁，
     * 取了后就在对应数列中删除这个数。然后再进行比较，如果有数列为空，那直接将另一个数列的数据依次取出即可。
     *
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(NlogN)。
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void merge_sort(int[] arr, int left, int right, int temp[]) {
        if (left < right) {
            int middle = (left + right) / 2;
            merge_sort(arr, left, middle, temp);//左半部分排好序
            merge_sort(arr, middle + 1, right, temp);//右半部分排好序
            mergeArray(arr, left, middle, right, temp); //合并左右部分
        }
    }

    //合并 ：将两个序列a[first-middle],a[middle+1-end]合并
    public static void mergeArray(int[] arr, int first, int middle, int end, int temp[]) {
        int i = first;
        int m = middle;
        int j = middle + 1;
        int k = 0;
        int n = end;

        while (i <= m && j <= n) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= m) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while (j <= n) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for (int ii = 0; ii < k; ii++) {
            arr[first + ii] = temp[ii];
        }
    }

    //将有序数组a[]和b[]合并到c[]中
    void memeryArray(int[] a, int[] b, int[] c) {
        int i, j, k;
        int n = a.length;
        int m = b.length;

        i = j = k = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < n) {
            c[k++] = a[i++];
        }

        while (j < m) {
            c[k++] = b[j++];
        }
    }

    /** 堆排序(HeapSort)
     *
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(NlogN)。
     *
     * @param arr
     * @param n
     */
    public static void heap_sort(int[] arr,int n){
        int temp = 0;
        heapMake(arr, n);

        for(int i=n-1; i>0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapFix(arr, 0, i);
        }
    }

    //构建最小堆
    public static void heapMake(int[] arr, int n){
        for(int i=(n-1)/2; i>=0 ; i--) {
            heapFix(arr, i, n);
        }
    }

    //从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
    public static void heapFix(int[] arr, int i, int n) {
        int j = 2*i+1; //子节点
        int temp = 0;

        while(j<n) {
            //在左右子节点中寻找最小的
            if(j+1<n && arr[j+1]<arr[j]) {
                j++;
            }

            if(arr[i] <= arr[j]) {
                break;
            }

            //较大节点下移
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i = j;
            j = 2*i+1;
        }
    }

    /** 基数排序(RadixSort)
     * 基本思想：
     * BinSort想法非常简单，首先创建数组A[MaxValue]；然后将每个数放到相应的位置上（例如17放在下标17的数组位置）；最后遍历数组，即为排序后的结果。
     *
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(d(n+r))。
     *
     * @param arr
     * @param temp
     * @param k
     * @param r
     * @param cnt
     */
    public static void radix_sort(int[] arr, int[] temp, int k, int r, int[] cnt) {
        //arr:原数组
        //temp:临时数组
        //k:最大的位数2
        //r:基数10
        //cnt:存储bin[i]的个数

        int n = arr.length;

        for(int i=0 , rtok=1; i<k ; i++ ,rtok = rtok*r) {
            //初始化
            for(int j=0; j<r; j++){
                cnt[j] = 0;
            }

            //计算每个箱子的数字个数
            for(int j=0; j<n; j++) {
                cnt[(arr[j]/rtok)%r]++;
            }

            //cnt[j]的个数修改为前j个箱子一共有几个数字
            for(int j=1; j<r; j++) {
                cnt[j] = cnt[j-1] + cnt[j];
            }

            for(int j = n-1; j>=0; j--) { //重点理解
                cnt[(arr[j]/rtok)%r]--;
                temp[cnt[(arr[j]/rtok)%r]] = arr[j];
            }

            for(int j=0; j<n; j++) {
                arr[j] = temp[j];
            }
        }
    }

    /** 顺序查找
     * 基本思想：
     * 顺序查找也称为线形查找，属于无序查找算法。
     * 从数据结构线形表的一端开始，顺序扫描，依次将扫描到的结点关键字与给定值k相比较，若相等则表示查找成功；
     * 若扫描结束仍没有找到关键字等于k的结点，表示查找失败。
     *
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(n)。
     *
     * @param arr
     * @param value
     * @return
     */
    public static int sequence_search(int[] arr, int value) {
        for(int i=0; i<arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /** 二分查找
     * 基本思想：
     * 也称为是折半查找，属于有序查找算法。
     * 用给定值k先与中间结点的关键字比较，中间结点把线形表分成两个子表，
     * 若相等则查找成功；若不相等，再根据k与该中间结点关键字的比较结果确定下一步查找哪个子表，
     * 这样递归进行，直到查找到或查找结束发现表中没有这样的结点。
     *
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(log2n)。
     *
     * @param arr
     * @param value
     * @return int
     */
    //二分查找（折半查找）
    public static int binary_search(int[] arr, int value) {
        int left = 0;
        int right = arr.length-1;
        int mid;

        while(left <= right)
        {
            mid = (left+right)/2;

            if(arr[mid] > value) {
                right = mid - 1;
            } else if(arr[mid] < value) {
                left = mid + 1;
            } else { // arr[mid] == value
                return mid;
            }
        }

        return -1;
    }

    //二分查找（递归版本）
    public static int binary_search(int[] arr, int value, int left, int right) {
        int mid = left+(right-left)/2;

        if(arr[mid] > value) {
            return binary_search(arr, value, left, mid - 1);
        } else if(arr[mid] < value) {
            return binary_search(arr, value, mid + 1, right);
        } else { //arr[mid] == value
            return mid;
        }
    }

    /** 插值查找
     * 基本思想：基于二分查找算法，将查找点的选择改进为自适应选择，可以提高查找效率。
     * 当然，差值查找也属于有序查找。
     * 注：对于表长较大，而关键字分布又比较均匀的查找表来说，插值查找算法的平均性能比折半查找要好的多。
     * 反之，数组中如果分布非常不均匀，那么插值查找未必是很合适的选择。
     *
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(log2(log2n))。
     *
     * @param arr
     * @param value
     * @param left
     * @param right
     * @return int
     */
    public static int insert_search(int[] arr, int value, int left, int right) {
        int len = arr.length;
        if(left > right || right > len-1 || value < arr[0] || value > arr[len-1]) {
            return -1;
        }

        int mid = left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);

        if(arr[mid] > value) {
            return insert_search(arr, value, left, mid - 1);
        } else if(arr[mid] < value) {
            return insert_search(arr, value, mid+1, right);
        } else { //arr[mid] == value
            return mid;
        }
    }

    /** 斐波那契查找
     * 基本思想：也是二分查找的一种提升算法，通过运用黄金比例的概念在数列中选择查找点进行查找，
     * 提高查找效率。同样地，斐波那契查找也属于一种有序查找算法。
     *
     * 复杂度分析：最坏情况下，时间复杂度为O(log2n)，且其期望复杂度也为O(log2n)。
     *
     * @param arr
     * @param value
     * @return int
     */
    public static int fibonacci_search(int[] arr, int value) { //arr为要查找的数组,n为要查找的数组长度,key为要查找的关键字
        int left = 0;
        int n = arr.length;
        int right = n-1;

        int[] _arr = new int[n];
        fibonacci(_arr);//构造一个斐波那契数组F

        int k=0;
        while(n > _arr[k]-1) {//计算n位于斐波那契数列的位置
            ++k;
        }

        int[] temp = new int [_arr[k]-1]; //将数组a扩展到F[k]-1的长度
        for(int i=n; i<_arr[k]-1; ++i) {
            temp[i] = arr[n - 1];
        }

        while(left <= right) {
            int mid = left + _arr[k - 1] - 1;
            if(value < temp[mid]) {
                right = mid - 1;
                k -= 1;
            } else if(value > temp[mid]) {
                left = mid + 1;
                k -= 2;
            } else {
                if(mid < n) {
                    return mid; //若相等则说明mid即为查找到的位置
                } else {
                    return n - 1; //若mid>=n则说明是扩展的数值,返回n-1
                }
            }
        }

        return -1;
    }

    //构造一个斐波那契数组
    public static void fibonacci(int[] arr) {
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
    }
}
