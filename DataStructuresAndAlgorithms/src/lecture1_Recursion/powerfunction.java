package lecture1_Recursion;

public class powerfunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2,y = 7;
		System.out.println(power(x,y));

	}
	
	public static int power(int x,int y){
		if(y == 1){
			return x;
		}
		
		int num = power(x,y/2);
		
		if(y%2 == 0){
			return  num*num;
		}else{
			return  x*num*num;
		}
	}

}
