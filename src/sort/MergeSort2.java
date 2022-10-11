package sort;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @program: Algorithm
 * @description:
 * @author: he-zx
 * @create: 2022-04-11 11:08
 **/
public class MergeSort2 {
	
	public void sort(int[] arr){
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
	}
	
	private void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid + 1, right, temp);
			merge(arr, left, mid, right, temp);
		}
	}
	
	private void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		t = 0;
		while (left <= right) {
			arr[left++] = temp[t++];
		}
	}
	
	public static void main(String[] args) {
		MergeSort2 mergeSort = new MergeSort2();
		int[] arr = new int[]{1, 3, 5, 3, 5, 2, 89, 6, 4};
		mergeSort.sort(arr);
		Stream.of(arr).forEach(a -> System.out.println(Arrays.toString(a)));
	}
	
	
}
