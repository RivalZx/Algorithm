package sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public int[] sort(int[] arr){
        int[] newArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < newArr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < newArr.length; j++) {
                if (newArr[j] < newArr[min])
                    min = j;
            }
            if (min != i) {
                int t = newArr[min];
                newArr[min] = newArr[i];
                newArr[i] = t;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] sort = selectionSort.sort(new int[]{1, 3, 5, 3, 5, 2, 89, 6, 4});
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }
}
