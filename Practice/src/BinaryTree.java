import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
	private class Node{
		int data;
		Node left;
		Node right;
	}
	
	Node root;
	int size;
	
	public BinaryTree(){
		Scanner scn = new Scanner(System.in);
		root = takeInput(null,true,scn);
	}
	
	public Node takeInput(Node parent,boolean ilc,Scanner scn){
		if(parent == null){
			System.out.println("Enter root data ");
		}else if(ilc){
			System.out.println("Enter "+parent.data +" left's child ");
		}else{
			System.out.println("Enter "+parent.data+" right's child ");
		}
		
		int data = scn.nextInt();
		
		Node child = new Node();
		child.data = data;
		this.size++;
		
		System.out.println("does "+ data +" has a left child ");
		boolean hlc = scn.nextBoolean();
		
		if(hlc){
			child.left = takeInput(child,true,scn);
		}
		
		System.out.println("does "+ data + " has a right child");
		boolean hrc = scn.nextBoolean();
		
		if(hrc){
			child.right = takeInput(child, false, scn);
		}
		
		return child;
	}
	
	public void display(){
		display(root);
	}
	
	public void display(Node parent){
		if(parent == null){
			return;
		}
		
		String str="";
		str+= parent.data +"=>";
		
		if(parent.left!= null){
			str+=parent.left.data+",";
		}
		
		if(parent.right!=null){
			str+=parent.right.data + ".";
		}
		
		System.out.println(str);
		display(parent.left);
		display(parent.right);
		
	}

	public void preorder(){
		preorder(root);
	}
	
	public void preorder(Node node){
		if(node == null){
			return;
		}
		
		System.out.print(node.data+" ");
		
		preorder(node.left);
		preorder(node.right);
		
	}
	
	public void inorder(){
		inorder(root);
	}
	
	public void inorder(Node node){
		if(node == null){
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
		
	}
	
	public void postorder(){
		postorder(root);
	}
	
	public void postorder(Node node){
		if(node == null){
			return;
		}
		
		postorder(node.left);
		postorder(node.right);
		
		System.out.print(node.data+" ");
	}
	
	public int height(){
		return height(root);
	}
	
	public int height(Node node){
		if(node == null){
			return -1;
		}
		
		int lh = height(node.left);
		int rh = height(node.right);
		
		return Math.max(lh, rh) + 1;
	}
	
	public void levelorder(){
		for(int i = 0;i<=this.height();i++){
			printlevel(i,root);
		}
	}
	
	public void printlevel(int level,Node node){
		if(node == null){
			return;
		}
		
		if(level == 0){
			System.out.print(node.data+" ");
		}else{
			printlevel(level -1,node.left);
			printlevel(level -1,node.right);
		}
	}
	
	public void levelorderIterative(){
		LinkedList<Node> queue = new LinkedList<>();
		
		queue.addLast(root);
		
		while(!queue.isEmpty()){
			Node node = queue.removeFirst();
			System.out.print(node.data +" ");
			
			if(node.left!=null){
				queue.addLast(node.left);
			}
			
			if(node.right!=null){
				queue.addLast(node.right);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
