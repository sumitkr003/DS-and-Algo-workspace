
public class BinaryTreeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		10 true 20 true 30 false false true 40 false false true 50 true 60 false false true 70 false false
		BinaryTree bt = new BinaryTree();
		
		bt.display();
		System.out.println();
		
		bt.preorder();
		System.out.println();
		
		bt.inorder();
		System.out.println();
		
		bt.postorder();
		System.out.println();
		
		System.out.println(bt.height());
		
		bt.levelorder();
		System.out.println();
		
		bt.levelorderIterative();
		
	}

}
