package www.arithmetic.com.arithmetic.sort;

public class InsertSort {
	/**
	 * 插入排序
	 * @param array
	 * @return
	 */
	public static int[] insertSort(int[] array){
		int j;
		for(int i = 0; i < array.length; i++){
			int tmp = array[i];
			for(j = i; j > 0 && array[j - 1] > tmp; j--){
				array[j] = array[j - 1];
			}
			array[j] = tmp;
		}
		return array;
	}
	
	/**
	 * 希尔排序
	 * @param array
	 * @return
	 */
	public static int[] shellSort(int[] array){
		int j;
		for(int gap = array.length / 2; gap > 0; gap /= 2){
			for(int i = gap; i < array.length; i++){
				int tmp = array[i];
				for(j = i; j>=gap && array[j - gap] > tmp; j -= gap){
					array[j] = array[j - gap];
				}
				array[j] = tmp;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = {2,8,4,9,14,5,7,13,11,1,4};
		InsertSort.shellSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "   ");
		}
	}
}
