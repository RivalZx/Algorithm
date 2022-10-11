package sort;

/**
 * @program: Algorithm
 * @description:
 * @author: he-zx
 * @create: 2022-04-11 10:59
 **/
public class QuickSort2 {
	
	public void sort(int[] arr){
		quickSort(arr, 0, arr.length - 1);
	}
	
	private void quickSort(int[] arr, int begin, int end) {
		int l = begin, r = end;
		if (l < r) {
			int key = arr[l];
			while (l < r && arr[r] > key) {
				r --;
			}
			if (l < r) {
				arr[l] = arr[r];
				l ++;
			}
			while (l < r && arr[l] < key) {
				l ++;
			}
			if (l < r) {
				arr[r] = arr[l];
				r --;
			}
			arr[l] = key;
			quickSort(arr, begin, l - 1);
			quickSort(arr, l + 1, end);
		}
	}
	

}
