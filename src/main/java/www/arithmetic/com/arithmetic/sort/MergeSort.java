package www.arithmetic.com.arithmetic.sort;

public class MergeSort {

//	public static int[] mergeSort(int[] array) {
//		int[] result = {};
//		if (result.length == array.length) {
//			return result;
//		}
//		
//		return null;
//	}
//
//	public static int[] merge(int[] array){
//		
//		return null;
//	}
//	
//	public static int[] part(int[] a, int[] b) {
//		int i = 0, j = 0, k = 0;
//		int[] c = new int[a.length + b.length];
//		while (i < a.length && j < b.length) {
//			if (a[i] < b[j]) {
//				c[k++] = a[i++];
//			} else {
//				c[k++] = b[j++];
//			}
//		}
//		if (i != a.length) {
//			for (; i < a.length; i++) {
//				c[k++] = a[i];
//			}
//		}
//		if (j != b.length) {
//			for (; j < b.length; j++) {
//				c[k++] = b[j];
//			}
//		}
//		return c;
//	}
	
	public static void mergeSort(int[] a){
		int[] tmpArray = new int[a.length];
		mergeSort(a, tmpArray,0,a.length - 1);
	}

	private static void mergeSort(int[] a, int[] tmpArray, int left, int right){
		if(left < right){
			int center = (left + right) / 2;
			mergeSort(a,tmpArray,left,center);
			mergeSort(a,tmpArray,center + 1,right);
			merge(a,tmpArray,left,center + 1,right);
		}
	}
 	
	private static void merge(int[] a, int[] tmpArray, 
			int leftPos, int rightPos, int rightEnd){
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		while(leftPos <= leftEnd && rightPos <= rightEnd){
			if(a[leftPos] <= a[rightPos]){
				tmpArray[tmpPos++] = a[leftPos++];
			} else {
				tmpArray[tmpPos++] = a[rightPos++];
			}
		}
		
		while(leftPos <= leftEnd){
			tmpArray[tmpPos++] = a[leftPos++];
		}
		
		while(rightPos <= rightEnd){
			tmpArray[tmpPos++] = a[rightPos++];
		}
		
		for(int i = 0; i < numElements;i++,rightEnd--){
			a[rightEnd] = tmpArray[rightEnd];
		}
	}
	
	
	public static void main(String[] args) {
		int[] array = {2,8,4,9,14,5,7,13,11,1,4};
		MergeSort.mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "   ");
		}
	}
}
