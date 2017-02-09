package www.arithmetic.com.arithmetic.sort;

/**
 * 快速排序
 * @author 313353
 *
 */
public class QuickSort {
	
	private static final int CUTOFF = 10;
	
	private static <AnyType extends Comparable<? super AnyType>> AnyType median3(
			AnyType[] a, int left, int right){
		int center = (left + right) / 2;
		if(a[center].compareTo(a[left]) < 0){
			swapReferences(a, left, center);
		}
		if(a[right].compareTo(a[left]) < 0){
			swapReferences(a, left, right);
		}
		if(a[right].compareTo(a[center]) < 0){
			swapReferences(a, center, right);
		}
		
		swapReferences(a, center, right - 1);
		
		return a[right - 1];
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void quickSort(
			AnyType[] a, int left, int right){
		if(left + CUTOFF <= right){
			AnyType pivot = median3(a, left, right);
			int i = left,j = right - 1;
			for(; ;){
				while(a[++i].compareTo(pivot) < 0){;}
				while(a[--j].compareTo(pivot) > 0){;}
				if(i < j){
					swapReferences(a, i, j);
				} else {
					break;
				}
			}
			
			swapReferences(a, i, right - 1);
			quickSort(a, left, i - 1);
			quickSort(a, i + 1, right);
		} else {
			//插入排序
			insertionSort(a, left, right);
		}
		
	}
	
	private static <AnyType extends Comparable<? super AnyType>>  void insertionSort(
			AnyType[] a, int left, int right){
		int j;
		for(int i = left;i <= right; i++){
			AnyType tmp = a[i];
			for(j = i;j > left && tmp.compareTo(a[j - 1]) <0; j--){
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void swapReferences(AnyType[] a, int left, int right){
		AnyType tmp = a[left];
		a[left] = a[right];
		a[right] = tmp;
	}
	
	public static  <AnyType extends Comparable<? super AnyType>> void quickSort(
			AnyType[] a){
		quickSort(a, 0, a.length - 1);
	}
	
	public static void main(String[] args) {
		Integer[] array = {2,8,4,9,14,5,7,13,11,1,4};
		QuickSort.quickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "   ");
		}
	}
}
