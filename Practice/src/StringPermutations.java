import java.util.Scanner;

public class StringPermutations {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
//		printpermutation("",str);
		
		subsequence("",str);

	}
	
	public static void printpermutation(String prefix,String str){
		int n = str.length();
		if(n == 0){
			System.out.println(prefix);
			return;
		}else{
			for(int i =0;i<n;i++){
				char ch = str.charAt(i);
				printpermutation(prefix + ch , str.substring(0, i) + str.substring(i+1));
			}
		}
	}
	
	public static void subsequence(String sub,String str){
		if(str.length() == 0){
			System.out.println(sub);
			return;
		}else{
			
				char ch = str.charAt(0);
				str = str.substring(1);
				subsequence(sub, str);
				subsequence(sub+ch, str);
			
			return;
		}
	}
}