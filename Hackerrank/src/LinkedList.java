
public class LinkedList {
	
	private class Node{
		int data;
		Node next;
	}
	
	Node head;
	Node tail;
	int size;
	
	private void handleat0(int num){
		Node node = new Node();
		node.data = num;
		node.next = null;
		
		this.head = node;
		this.tail = node;
		this.size++;
	}
	
	public void addlast(int num){
		if(head == null){
			handleat0(num);
		}else{
			Node node = new Node();
			node.data = num;
			node.next = null;
			
			this.tail.next = node;
			this.tail = node;
			this.tail.next = node.next;
		}
	}
	
	public void addfirst(int num){
		if(this.head == null){
			handleat0(num);
		}else{
			Node node = new Node();
			node.data = num;
			node.next = this.head;
			
			this.head = node;
			this.size++;
		}
		
	}
	
	public void display(){
		Node node = head;
		while(node!=null){
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	public void addatindex(int num,int idx){
		if(this.head == null){
			handleat0(num);
		}else if(idx == this.size){
			addlast(num);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}