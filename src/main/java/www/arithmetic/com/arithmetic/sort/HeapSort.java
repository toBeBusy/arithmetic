package www.arithmetic.com.arithmetic.sort;

public class HeapSort {
	
	private static int leftChild(int i){
		return 2 * i;
	}

	private static void percDown(int[] a, int i, int n){
		int child;
		int tmp;
		for(tmp = a[i]; leftChild(i) < n; i = child){
			child = leftChild(i);
			if(child != n - 1 && a[child] < a[child + 1]){
				child++;
			}
			if(tmp < a[child]){
				a[i] = a[child];
			} else {
				break;
			}
		}
		a[i] = tmp;
	}
	
	public static int[] heapSort(int[] a){
		for(int i = a.length/2; i>=0; i--){
			percDown(a,i,a.length);
		}
		for(int i = a.length - 1; i > 0; i--){
			percDown(a,0,i);
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		int[] array = {2,8,4,9,14,5,7,13,11,1,4};
		HeapSort.heapSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "   ");
		}
	}
}
