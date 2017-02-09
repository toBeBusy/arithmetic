package www.arithmetic.com.arithmetic;

public class Heap {
	private static final int DEFAULT_SIZE = 10;
	private int[] array;
	private int size;
	private int position = 1;
	
	public Heap(){
		size = DEFAULT_SIZE;
		array = new int[DEFAULT_SIZE];
	}
	
	public Heap(int size){
		this.size = size;
		array = new int[size];
	}
	
	public void insert(int data){
		int hole = position;
		if(hole > size){
			this.expend();
		}
		for(;hole > 1 && array[hole / 2] > data; hole = hole / 2){
			array[hole] = array[hole / 2];
		}
		array[hole] = data;
		position++;
	}
	
	public void deleteMin() throws Exception{
		if(isEmpty()){
			throw new Exception("内容为空，无法删除。");
		}
		array[1] = array[position - 1];
		percolateDown(1);
		position--;
	}
	
	public void percolateDown(int hole){
		int temp = array[hole];
		int child = hole * 2;
		while(child <= position - 1){
			if(child != position - 1 && array[child] > array[child + 1]){
				child++;
			}
			if(array[child] < temp){
				array[hole] = array[child];
				hole = child;
				child = hole * 2;
			} else {
				break;
			}
		}
		array[hole] = temp;
	}
	
	public void expend(){ 
		size = size * 2;
		int[] newArray = new int[size];
		for(int i = 0; i < array.length; i++){
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
	public boolean isEmpty(){
		return position == 1;
	}
	
	public int deleteMinBook() throws Exception{
		if(isEmpty()){
			throw new Exception("内容为空，无法删除。");
		}
		int min = array[1];
		array[1] = array[--position];
		percolateDownBook(1);
		return min;
	}
	
	public void percolateDownBook(int hole){
		int child;
		int temp = array[hole];
		
		for(;hole * 2 <= position -1;hole = child){
			child = hole * 2;
			if(child != position -1 && array[child + 1] < array[child]){
				child++;
			}
			if(array[child] < temp){
				array[hole] = array[child];
			} else {
				break;
			}
		}
		
		array[hole] = temp;
	}
	
	public static void main(String[] args) throws Exception {
		 Heap heap = new Heap();
		 heap.insert(2);
		 heap.insert(8);
		 heap.insert(5);
		 heap.insert(3);
		 heap.insert(7);
		 heap.insert(4);
		 heap.insert(6);
		 heap.insert(5);
		 heap.insert(2);
		 System.out.println("...");
		 
		 Heap heap2 = new Heap();
		 heap2.insert(2);
		 heap2.insert(8);
		 heap2.insert(5);
		 heap2.insert(3);
		 heap2.insert(7);
		 heap2.insert(4);
		 heap2.insert(6);
		 heap2.insert(5);
		 heap2.insert(2);

		 heap.deleteMin();
		 heap.deleteMin();
		 heap2.deleteMinBook();
		 heap2.deleteMinBook();
		 System.out.println("...");
	}
}
