package BinaryTree;

	import java.util.LinkedList;
	import java.util.Scanner;

public class BinaryTree {
	
		private class Node {
			int data;
			Node left;
			Node right;
		}

		Node root;
		int size;

		public BinaryTree() {
			Scanner scn = new Scanner(System.in);
			root = takeinput(null, false, scn);
		}

		public Node takeinput(Node parent, boolean ilc, Scanner scn) {
			if (parent == null) {
				System.out.println("enter root data?");
			} else {
				if (ilc) {
					System.out.println("enter " + parent.data + " lefts child");
				} else {
					System.out.println("enter " + parent.data + " right child");
				}
			}

			int data = scn.nextInt();

			Node child = new Node();
			child.data = data;
			this.size++;

			// left
			System.out.println("does " + child.data + " has a left child");
			boolean hlc = scn.nextBoolean();
			if (hlc) {
				child.left = takeinput(child, true, scn);
			}

			// right
			System.out.println("does " + child.data + " has a right child");
			boolean hrc = scn.nextBoolean();
			if (hrc) {
				child.right = takeinput(child, false, scn);
			}

			return child;
		}

		public BinaryTree(int[] post, int[] in) {
			root = constructor(post, in, 0, post.length - 1, 0, in.length - 1);
		}

		private Node constructor(int[] post, int[] in, int psi, int pei, int isi, int iei) {
			if (psi > pei || isi > iei) {
				return null;
			}

			Node node = new Node();
			node.data = post[pei];
			this.size++;

			int idx = -1;
			for (int i = isi; i <= iei; i++) {
				if (in[i] == node.data) {
					idx = i;
					break;
				}
			}

			int clse = idx - isi;

			node.left = constructor(post, in, psi, psi + clse - 1, isi, idx - 1);
			node.right = constructor(post, in, psi + clse, pei - 1, idx + 1, iei);

			return node;

		}

		public void display() {
			display(root);
		}

		private void display(Node node) {
			if (node == null) {
				return;
			}

			String str = "";
			if (node.left != null) {
				str += node.left.data + "";
			} else {
				str += ".";
			}

			str += "=>" + node.data + "<=";

			if (node.right != null) {
				str += node.right.data + "";
			} else {
				str += ".";
			}

			System.out.println(str);
			display(node.left);
			display(node.right);
		}

		public int size() {
			return this.size;
		}

		public boolean isempty() {
			return this.size == 0;
		}

		public int size2() {
			return size2(root);
		}

		private int size2(Node node) {
			if (node == null) {
				return 0;
			}

			int left = size2(node.left);
			int right = size2(node.right);

			return left + right + 1;
		}

		public int height() {
			return height(root) - 1;
		}

		private int height(Node node) {
			int h = -1;

			int left = 0, right = 0;
			if (node.left != null) {
				left = height(node.left);
			}

			if (node.right != null) {
				right = height(node.right);
			}

			if (left > right) {
				h = left;
			} else {
				h = right;
			}

			return h + 1;
		}

		public int max() {
			return max(root);
		}

		private int max(Node node) {
			int max = node.data;

			int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
			if (node.left != null) {
				left = max(node.left);
			}
			if (node.right != null) {
				right = max(node.right);
			}

			if (left > right && left > max) {
				max = left;
			} else if (right >= left && right > max) {
				max = right;
			}

			return max;
		}

		public boolean isfound(int data) {
			return isfound(root, data);
		}

		private boolean isfound(Node node, int data) {
			if (node == null) {
				return false;
			}

			boolean a = isfound(node.left, data);
			if (a == true) {
				return true;
			}

			boolean b = isfound(node.right.data);
			if (b == true) {
				return true;
			}

			return false;

		}

		public int diameter() {
			return diameter(root);
		}

		private int diameter(Node node) {
			if (node == null) {
				return 0;
			}

			int left = diameter(node.left);
			int right = diameter(node.right);
			int lefth = height(node.left);
			int righth = height(node.right);

			return Math.max(left + right + 2, Math.max(lefth, righth));

		}

		public int diameter2() {
			return diameter2(root).diameter;

		}

		public class diapair {
			int diameter;
			int height;
		}

		private diapair diameter2(Node node) {
			if (node == null) {
				diapair bp = new diapair();
				bp.height = -1;
				bp.diameter = 0;
				return bp;
			}

			diapair mp = new diapair();

			diapair left = diameter2(node.left);
			diapair right = diameter2(node.right);

			mp.diameter = (Math.max(left.height + right.height + 2, (Math.max(left.diameter, right.diameter))));
			mp.height = Math.max(left.height, right.height) + 1;

			return mp;
		}

		public boolean isbalanced() {
			return isbalanced(root).bal;
		}

		private isbalance isbalanced(Node node) {
			if (node == null) {
				isbalance bc = new isbalance();
				bc.bal = true;
				bc.height = -1;
				return bc;
			}
			isbalance mp = new isbalance();

			isbalance left = isbalanced(node.left);
			isbalance right = isbalanced(node.right);

			if (left.bal == false || right.bal == false) {
				return mp;
			}

			int dif = left.height - right.height;

			if (dif <= 1 && dif >= -1) {
				mp.bal = true;
			}

			mp.height = Math.max(left.height, right.height) + 1;

			if (mp.bal == false) {
				return mp;
			}

			return mp;
		}

		private class isbalance {
			boolean bal = true;
			int height;
		}

		private class bstpair {
			boolean bal = true;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int bstsize;
			Node bstroot;
		}

		public boolean bst() {
			return bst(root).bal;
		}

		private bstpair bst(Node node) {
			if (node == null) {
				bstpair bp = new bstpair();
				bp.bal = true;
				bp.max = Integer.MIN_VALUE;
				bp.min = Integer.MAX_VALUE;
				return bp;
			}

			bstpair left = bst(node.left);
			bstpair right = bst(node.right);

			bstpair mp = new bstpair();

			if (left.bal == false || right.bal == false) {
				mp.bal = false;
			} else {
				if (left.max < right.min) {
					if (node.data > left.max && node.data < right.min) {
						mp.max = Math.max(node.data, right.max);
						mp.min = Math.min(node.data, left.min);
						mp.bal = true;
					} else {
						mp.bal = false;
					}
				} else {
					mp.bal = false;
				}
			}
			
			if(mp.bal){
				mp.bstroot = node;
				mp.bstsize = left.bstsize + right.bstsize + 1;
			}else{
				if(left.bstsize>right.bstsize){
					mp.bstroot = left.bstroot;
					mp.bstsize = left.bstsize;
				}else{
					mp.bstroot = right.bstroot;
					mp.bstsize = right.bstsize;
				}
			}
			return mp;
		}

		public void preorder() {
			preorder(root);
		}

		private void preorder(Node node) {
			if (node == null) {
				return;
			}

			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}

		public void postorder() {
			postorder(root);
		}

		private void postorder(Node node) {
			if (node == null) {
				return;
			}

			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
		}

		public void inorder() {
			inorder(root);
		}

		private void inorder(Node node) {
			if (node == null) {
				return;
			}

			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}

		public void preorderiterative() {
			LinkedList<Transversalpair> stack = new LinkedList<>();

			Transversalpair rp = new Transversalpair();
			rp.node = root;

			stack.addFirst(rp);
			while (stack.size() != 0) {

				Transversalpair temp = stack.getFirst();

				if (temp.selfdone == false) {
					System.out.print(temp.node.data + " ");
					temp.selfdone = true;
				} else if (temp.leftdone == false) {
					if (temp.node.left == null) {
						temp.leftdone = true;
					} else {
						temp.leftdone = true;
						Transversalpair tempnew = new Transversalpair();
						tempnew.node = temp.node.left;
						stack.addFirst(tempnew);
					}

				} else if (temp.rightdone == false) {
					if (temp.node.right == null) {
						temp.rightdone = true;
					} else {
						temp.rightdone = true;
						Transversalpair tempnew = new Transversalpair();
						tempnew.node = temp.node.right;
						stack.addFirst(tempnew);
					}
				} else {
					stack.removeFirst();
				}
			}
		}

		public void postorderI() {
			LinkedList<Transversalpair> stack = new LinkedList<>();

			Transversalpair rp = new Transversalpair();
			rp.node = root;

			stack.addFirst(rp);
			while (stack.size() != 0) {

				Transversalpair temp = stack.getFirst();

				if (temp.leftdone == false) {
					if (temp.node.left == null) {
						temp.leftdone = true;
					} else {
						temp.leftdone = true;
						Transversalpair tempnew = new Transversalpair();
						tempnew.node = temp.node.left;
						stack.addFirst(tempnew);
					}

				} else if (temp.rightdone == false) {
					if (temp.node.right == null) {
						temp.rightdone = true;
					} else {
						temp.rightdone = true;
						Transversalpair tempnew = new Transversalpair();
						tempnew.node = temp.node.right;
						stack.addFirst(tempnew);
					}
				} else if (temp.selfdone == false) {
					System.out.print(temp.node.data + " ");
					temp.selfdone = true;
				} else {
					stack.removeFirst();
				}
			}
		}

		public void inorderI() {
			LinkedList<Transversalpair> stack = new LinkedList<>();

			Transversalpair rp = new Transversalpair();
			rp.node = root;

			stack.addFirst(rp);
			while (stack.size() != 0) {

				Transversalpair temp = stack.getFirst();

				if (temp.leftdone == false) {
					if (temp.node.left == null) {
						temp.leftdone = true;
					} else {
						temp.leftdone = true;
						Transversalpair tempnew = new Transversalpair();
						tempnew.node = temp.node.left;
						stack.addFirst(tempnew);
					}

				} else if (temp.selfdone == false) {
					System.out.print(temp.node.data + " ");
					temp.selfdone = true;
				} else if (temp.rightdone == false) {
					if (temp.node.right == null) {
						temp.rightdone = true;
					} else {
						temp.rightdone = true;
						Transversalpair tempnew = new Transversalpair();
						tempnew.node = temp.node.right;
						stack.addFirst(tempnew);
					}
				} else {
					stack.removeFirst();
				}
			}
		}

		public void levelorderI() {
			LinkedList<Node> stack = new LinkedList<>();

			stack.addLast(root);

			while (stack.size() != 0) {
				Node temp = stack.getFirst();

				if (temp.left != null) {
					stack.addLast(temp.left);

				}

				if (temp.right != null) {
					stack.addLast(temp.right);
				}

				System.out.print(temp.data + " ");
				stack.removeFirst();

			}
		}

		private class Transversalpair {
			Node node;
			boolean selfdone;
			boolean leftdone;
			boolean rightdone;
		}
		
		public void withoutsiblings(){
			withoutsiblings(root,null,false);
		}
		
		private void withoutsiblings(Node node,Node parent,boolean ilc){
			if(node == null){
				return;
			}
			if(node.left==null && node.right!=null){
				if(ilc){
					System.out.print(node.left.data+" ");
				}else{
					System.out.print(node.right.data+" ");
				}
			}
			
			if(node.left!=null && node.right==null){
				if(ilc){
					System.out.print(node.left.data+" ");
				}else{
					System.out.print(node.right.data+" ");
				}
			}
			
			withoutsiblings(node.left,node,true);
			withoutsiblings(node.right,node,false);
		}
		
		public void removeleaves(){
			removeleaves(root,null,false);
		}
		
		public void removeleaves(Node node,Node parent,boolean ilc){
			if(node == null){
				return;
			}
			
			if(node.right == null && node.left == null){
				if(ilc){
					parent.left = null;
				}else{
					parent.right = null;
				}
			}
			
			removeleaves(node.left,node,true);
			removeleaves(node.right,node,false);
		}
		
		public void ismirror(BinaryTree bt){
			System.out.println(ismirror(this.root,bt.root));
		}
		
		private boolean ismirror(Node node , Node node1){
			if(node == null && node1 == null){
				return true;
			}
			
			if(node == null || node1 == null){
				return false;
			}
			
			if(node.data!=node1.data){
				return false;
			}
			
			boolean b = ismirror(node.left,node1.right);
			
			if(b == false){
				return false;
			}
			else{
				return ismirror(node.right,node1.left);
			}
			
			
		}

		public void remove_nodes_on_root_to_leafpath(int k){
			removenodes(root,null,1,k,false);
		}
		
		private void removenodes(Node node,Node parent,int n,int k,boolean ilc){
			if(node == null){
				if(n<=k){
					if(ilc){
						parent.left = null;
					}else{
						parent.right = null;
					}
				}
				return;
			}
			removenodes(node.left,node,n+1,k,true);
			removenodes(node.right,node,n+1,k,false);
			
			if(n<k && node.left == null && node.right == null){
				if(ilc){
					parent.left = null;
				}else{
					parent.right = null;
				}
			}
		}

































}
