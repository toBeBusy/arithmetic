package www.arithmetic.com.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 加权最短路径算法，Dijkstra算法
 * 
 * @author 313353
 *
 */
public class Dijkstra {
	
	protected List<Vertex> vertexList = new ArrayList<Vertex>();
	
	public Dijkstra() {
		createNearTable();
	}
	
	/**
	 * 顶点类 
	 * @author 313353
	 *
	 */
	public static class Vertex {
		//最短路径长
		protected int dist = -1;
		//最短路径都经过哪些顶点(有序)
		protected List<Vertex> road = new ArrayList<Vertex>();
		//相邻的顶点
		protected Map<Vertex, Integer> nearVertex = new HashMap<Vertex, Integer>();
	}
	
	/**
	 * 根据给出的图，创建邻接表
	 */
	public void createNearTable() {
		Vertex one = new Vertex();
		Vertex two = new Vertex();
		Vertex three = new Vertex();
		Vertex four = new Vertex();
		Vertex five = new Vertex();
		Vertex six = new Vertex();
		Vertex seven = new Vertex();
		
		one.nearVertex.put(two, 2);
		one.nearVertex.put(four, 1);
		
		two.nearVertex.put(four, 3);
		two.nearVertex.put(five, 10);
		
		three.nearVertex.put(one, 4);
		three.nearVertex.put(six, 5);
		
		four.nearVertex.put(three, 2);
		four.nearVertex.put(five, 2);
		four.nearVertex.put(six, 8);
		four.nearVertex.put(seven, 4);
		
		five.nearVertex.put(seven, 6);
		
		seven.nearVertex.put(six, 1);
		
		vertexList.add(one);
		vertexList.add(two);
		vertexList.add(three);
		vertexList.add(four);
		vertexList.add(five);
		vertexList.add(six);
		vertexList.add(seven);
	}
	
	public void dijkstra(Vertex vertex) {
		//找出相邻的顶点
		Map<Vertex, Integer> nearVertex = vertex.nearVertex;
		if(!nearVertex.isEmpty()){
			Iterator<Entry<Vertex, Integer>> it = nearVertex.entrySet().iterator();
			while(it.hasNext()){
				Entry<Vertex, Integer> entry= it.next();
				Vertex near= entry.getKey();
				//判断当前路径是否小于当前路径
				if(near.dist > vertex.dist + entry.getValue()) {
					near.dist = vertex.dist + entry.getValue();
					near.road = vertex.road;
					near.road.add(near);
				}
				dijkstra(near);
			}
		}
	}
	
	public static void main(String[] args) {
		Dijkstra d = new Dijkstra();
		d.dijkstra(d.vertexList.get(0));
		System.out.println("");
	}
}
