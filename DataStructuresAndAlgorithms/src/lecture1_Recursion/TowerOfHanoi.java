package lecture1_Recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		toh(n,'A','B','C');

	}
	
	public static void toh(int n,char src,char helper,char dest){
		if(n == 0){
			return;
		}
		
		toh(n-1,src,dest,helper);
		System.out.println("move "+ n +" disk from " + src + " to " + dest);
		toh(n-1,helper,src,dest);
	}

}
