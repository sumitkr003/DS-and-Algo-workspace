package CODE_a_THON;

import java.util.Scanner;

public class lcm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		long k = scn.nextLong();
		long res = 0;
		for(long i = 1;i<=k;i++){
			res+=gcd(i,k);
		}
//		System.out.println(gcd(5,2));
		System.out.println(res);

	}
	
	public static long gcd(long i,long j){
		long num1 = i,num2 = j;
		long rem = 1;
		while(rem!=0){
			rem = j%i;
			j = i;
			i = rem;
		}
		long num =  num1*num2/j;
		return num;
	}

}
