package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public int[] sort(int[] arr){
        int[] res = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (res[j] > res[j + 1]) {
                    int temp = res[j];
                    res[j] = res[j + 1];
                    res[j + 1] = temp;
                    flag = false;
                }
            }
            if (!flag)
                break;
        }
        return res;
    }
}
