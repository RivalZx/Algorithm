package sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {
    public int[] sort(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < newArr.length; i++) {
            int tmp = newArr[i];
            int j = i;
            while (j > 0 && tmp < newArr[j - 1]) {
                newArr[j] = newArr[j - 1];
                j --;
            }
            if (j != i) {
                newArr[j] = tmp;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] sort = insertionSort.sort(new int[]{1, 3, 4, 5, 1, 3, 76, 34, 8});
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + "\t");
        }
    }
}
