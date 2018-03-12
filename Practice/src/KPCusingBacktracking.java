import java.util.Scanner;

public class KPCusingBacktracking {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String codes = scn.next();
		
		kpc(codes,"");
		
	}
	
	public static String codes(char ch){
		if(ch=='1'){
			return "abc";
		}
		else if(ch=='2'){
			return "def";
		}
		else if(ch=='3'){
			return "ghi";
		}
		else if(ch=='4'){
			return "jkl";
		}
		else if(ch=='5'){
			return "mno";
		}
		else if(ch=='6'){
			return "pqrs";
		}
		else if(ch=='7'){
			return "tuv";
		}
		else if(ch=='8'){
			return "wx";
		}
		else if(ch=='9'){
			return "yz";
		}
		else {
			return ".;_";
		}
	}
	
	public static void kpc(String code,String ans){
		if(code.length() == 0){
			System.out.println(ans);
			return;
		}
		
		char ch = code.charAt(0);
		String str = codes(ch);
		
		for(int i = 0;i<str.length();i++){
			kpc(code.substring(1),ans+str.charAt(i));
		}
	}

}
