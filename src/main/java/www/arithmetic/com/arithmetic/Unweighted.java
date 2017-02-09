package www.arithmetic.com.arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 无权最短路径算法。广度优先搜索。
 * 
 * 第一步：根据图，创建邻接表
 * 第二步：选取起点，设置起点路径长(length)为0
 * 第三步：创建未探索队列(也可以是栈，无所谓)，将起点置于队列中
 * 第四步：设置起点的相邻点的路径长(length)，同时将相邻点置于为探索队列中
 * 第五步： 若未探索队列不为空，则循环从为探索队列中取值，设置取出值的相邻点的路径长，同时将其置于探索队列中
 * 
 * @author 313353
 * 
 */
public class Unweighted {
	
	List<Vertex> vertexList;
	
	public Unweighted(){
		init();
	}
	
	/**
	 * 原型模式，克隆方法，加快创建对象的速度
	 * @author 313353
	 * 
	 */
	private class Vertex implements Cloneable {
		protected int length = -1;
		protected List<Vertex> nearVertex = new ArrayList<Vertex>();
		
		@SuppressWarnings("unchecked")
		public Vertex cloneVertex(){
			Vertex cloneObject = null;
			try {
				cloneObject = (Vertex) this.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			cloneObject.nearVertex = (List<Vertex>) ((ArrayList<Vertex>)this.nearVertex).clone();
			
			return cloneObject;
		}
	}
	
	/**
	 * 初始化方法，根据给出的图，生成邻接表
	 */
	public void init(){
		List<Vertex> vertexList = new ArrayList<Vertex>(20);
		Vertex one = new Vertex();
		one.nearVertex = new ArrayList<Vertex>();
		Vertex two = one.cloneVertex();
		Vertex three = one.cloneVertex();
		Vertex four = one.cloneVertex();
		Vertex five = one.cloneVertex();
		Vertex six = one.cloneVertex();
		Vertex seven = one.cloneVertex();
		
		one.nearVertex.add(two);
		one.nearVertex.add(four);
		
		two.nearVertex.add(four);
		two.nearVertex.add(five);
		
		three.nearVertex.add(one);
		three.nearVertex.add(six);
		
		four.nearVertex.add(three);
		four.nearVertex.add(five);
		four.nearVertex.add(six);
		four.nearVertex.add(seven);
		
		five.nearVertex.add(seven);
		
		seven.nearVertex.add(six);
		
		vertexList.add(one);
		vertexList.add(two);
		vertexList.add(three);
		vertexList.add(four);
		vertexList.add(five);
		vertexList.add(six);
		vertexList.add(seven);
		
		this.vertexList = vertexList;
	}
	
	/**
	 * 无权最短路径算法。
	 */
	public void unweighted(){
		//未探索队列(也可以是栈，无所谓)
		Stack<Vertex> unknowStack = new Stack<Vertex>();
		//初始点
		Vertex first = vertexList.get(2);
		first.length = 0;
		//初始点入栈
		unknowStack.push(first);
		int resentLength;
		//判断栈是否为空
		while(!unknowStack.isEmpty()){
			//从栈中取出为探索的点
			Vertex current = unknowStack.pop();
			//获取当前未探索的点的长度
			resentLength = current.length;
			//循环遍历未探索的点的相邻点
			for(Vertex near : current.nearVertex){
				//判断相邻点是路径长度是否已被设置(是否已有更短路径)
				if(near.length == -1){
					//设置相邻点路径
					near.length = resentLength + 1;
					//相邻点入栈，用于接下来的探索
					unknowStack.push(near);
				}
			}
		}
		
	}
	
	/**
	 * 打印结果。
	 */
	public void printLength(){
		for (int i = 0; i < vertexList.size(); i++) {
			Vertex vertex = vertexList.get(i);
			System.out.println("第" + (i + 1) + "个顶点，距离是:" + vertex.length);
		}
	}
	
	public static void main(String[] args) {
		Unweighted unweighted = new Unweighted();
		unweighted.unweighted();
		unweighted.printLength();
	}
}
