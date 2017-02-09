package www.arithmetic.com.arithmetic.sort;

public class SelfMergeSort {

	private static <AnyType extends Comparable<? super AnyType>> void mergeSort(
			AnyType[] data,AnyType[] tmp, int left, int right){
		if(left < right){
			int center = (right + left) / 2;
			mergeSort(data,tmp,left,center);
			mergeSort(data,tmp,center + 1,right);
			merge(data,tmp,left,right,center);
		}
	}
	
	private static <AnyType extends Comparable<? super AnyType >> void merge(
			AnyType[] data,AnyType[] tmp, int left, int right, int center){
		int orgLeft = left;
		int leftStr = left;
		int rightStr = center + 1;
		while(leftStr <= center && rightStr <= right){
			if(data[leftStr].compareTo(data[rightStr]) < 0){
				tmp[left++] = data[leftStr++];
			} else {
				tmp[left++] = data[rightStr++];
			}
		}
		while(leftStr <= center){
			tmp[left++] = data[leftStr++];
		}
		while(rightStr <= right){
			tmp[left++] = data[rightStr++];
		}
		for(;orgLeft <= right; orgLeft++){
			data[orgLeft] = tmp[orgLeft];
		}
	} 
	
	public static <AnyType extends Comparable<? super AnyType>> void mergeSort(
			AnyType[] data){
		@SuppressWarnings("unchecked")
		AnyType[] tmp = (AnyType[])new Comparable[data.length];
		mergeSort(data, tmp, 0, data.length - 1);
	}
	
	public static void main(String[] args) {
		Integer[] array = {2,8,4,9,14,5,7,13,11,1,4};
		SelfMergeSort.mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "   ");
		}
	}
}
