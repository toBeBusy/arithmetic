package www.arithmetic.com.arithmetic;

import java.util.LinkedList;


public class AvlTree<AnyType extends Comparable<AnyType>> {
	
	private static class AvlNode<AnyType>{
		AnyType element;
		AvlNode<AnyType> leftNode;
		AvlNode<AnyType> rightNode;
		int heigh;
		
		public AvlNode(AnyType element,AvlNode<AnyType> leftNode, AvlNode<AnyType> rightNode){
			this.element = element;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.heigh = 0;
			new LinkedList<String>();
		}
	}
	
	private int heigh(AvlNode<AnyType> t){
		return t==null ? -1 : t.heigh;
	}
	
	public AvlNode<AnyType> insert(AnyType e, AvlNode<AnyType> node){
		if(node == null){
			return new AvlNode<AnyType>(e, null, null);
		}
		int compareResult = e.compareTo(node.element);
		
		if(compareResult < 0){
			node.leftNode = insert(e, node.leftNode);
		} else if(compareResult > 0){
			node.rightNode = insert(e, node.rightNode);
		}
		return balance(node);
	}
	
	public AvlNode<AnyType> remove(AnyType x,AvlNode<AnyType> t){
		if(t == null){
			return t;
		}
		int compareResult = x.compareTo(t.element);
		if(compareResult < 0){
			t.leftNode = remove(x, t.leftNode);
		} else if(compareResult > 0){
			t.rightNode = remove(x, t.rightNode);
		} else if(t.leftNode != null && t.rightNode != null){
			t.element = findMin(t.rightNode).element;
			t.rightNode = remove(t.element, t.rightNode);
		}
		else{
			t = (t.leftNode != null) ? t.leftNode : t.rightNode;
		}
		return t;
	}
	
	public AvlNode<AnyType> findMin(AvlNode<AnyType> node){
		if(node.leftNode != null){
			return findMin(node.leftNode);
		} else {
			return node;
		}
	}
	
	private static final int ALLOWED_IMBALANCE = 1;
	
	private AvlNode<AnyType> balance(AvlNode<AnyType> node){
		if(node == null){
			return node;
		}
		//TODO
		if(heigh(node.leftNode) - heigh(node.rightNode) > ALLOWED_IMBALANCE){
//			if(Compare())
		}
		return null;
	}
	
	/**
	 * 左子树单旋
	 * @param k2
	 * @return
	 */
	private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2){
		AvlNode<AnyType> k1 = k2.leftNode;
		k2.leftNode = k1.rightNode;
		k1.rightNode = k2;
		k2.heigh = Math.max(k2.leftNode.heigh, k2.rightNode.heigh) + 1;
		k1.heigh = Math.max(k1.leftNode.heigh, k2.heigh) + 1;
		return k1;
	}
	
	/**
	 * 右子树单旋
	 * @param k2
	 * @return
	 */
	private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k2){
		AvlNode<AnyType> k1 = k2.rightNode;
		k2.rightNode = k1.leftNode;
		k1.leftNode = k2;
		k2.heigh = Math.max(k2.leftNode.heigh, k2.rightNode.heigh) + 1;
		k1.heigh = Math.max(k1.rightNode.heigh, k2.heigh) + 1;
		return k1;
	}
	
	/**
	 * 左子树双旋
	 * @param k3
	 * @return
	 */
	private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3){
		k3.leftNode = rotateWithRightChild(k3.leftNode);
		return rotateWithLeftChild(k3);
	}
}
