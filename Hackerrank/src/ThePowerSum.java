import java.util.Scanner;

public class ThePowerSum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		int n = scn.nextInt();
		
		System.out.println(powersum(x,n,0,0,1,""));
	}
	
	public static int powersum(int x,int n,int sum,int count,int cur,String ans){
		if(sum == x){
			count++;
			System.out.println(ans);
			return count;
		}
		else if(sum>x){
			return count;
		}
		
		for(int i = cur;x>=(int)Math.pow(i, n);i++){
			count = powersum(x,n,sum + (int)Math.pow(i, n),count,i+1,ans+i);
		}
		
		return count;
	}

}
