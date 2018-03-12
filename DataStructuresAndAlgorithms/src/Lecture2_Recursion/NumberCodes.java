package Lecture2_Recursion;

public class NumberCodes {

	public static void main(String[] args) {
		int num = 123;
		printcodes(num,"");

	}
	
	public static void printcodes(int num,String ans){
		if(num<=0){
			System.out.println(ans);
			return;
		}
		
		int code1 = num%10;
		int code2 =  num%100;
		if(code1!=0){
			num = num/10;
			char ch = (char)(code1 + 64);
			ans = ch + ans;
			printcodes(num,ans);
		}
		
		if(code2>9 && code2<27){
			char ch = (char)(code2+64);
			num = num/100;
			ans = ch+ans;
			printcodes(num,ans);
		}
	}

}
