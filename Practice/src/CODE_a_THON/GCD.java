package CODE_a_THON;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		while(k!=0){
			int result = 0;
			for(int i = 1;i<k;i++){
				for(int j = i+1;j<=k;j++){
					result+= gcd(i,j);
				}
			}
			System.out.println(result);
			k = scn.nextInt();
		}
//		System.out.println(gcd(5,10));

	}
	
	public static int gcd(int i,int j){
		int rem = 1;
		while(rem!=0){
			rem = j%i;
			j = i;
			i = rem;
		}
		return j;
	}

}
