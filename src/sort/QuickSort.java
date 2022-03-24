package sort;

import java.util.Arrays;

/**
 * 快排
 */
public class QuickSort {
    public void sort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int key = arr[begin];
            int i = begin, j = end;
            while (i < j) {
                while (i < j && arr[j] > key) {
                    j --;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i ++;
                }

                while (i < j && arr[i] < key) {
                    i ++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j --;
                }
                arr[i] = key;
                quickSort(arr, begin, i - 1);
                quickSort(arr, i + 1, end);
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {5, 9, 1, 9, 5, 3, 7, 6, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        Arrays.stream(array).forEach(a -> System.out.println(a));
    }
}
