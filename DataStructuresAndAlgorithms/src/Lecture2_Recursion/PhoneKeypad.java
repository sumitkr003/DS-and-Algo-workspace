package Lecture2_Recursion;

public class PhoneKeypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "123";
		phonecodes(str,"");
	}
	
	public static void phonecodes(String str,String ans){
		//base case
		if(str.length()==0){
			System.out.println(ans);
			return;
		}
		
		char ch = str.charAt(0);
		String code = codes(ch);
		str = str.substring(1);
		for(int i = 0;i<code.length();i++){
			char c = code.charAt(i);
			phonecodes(str,ans+c);
		}
	}
	
	public static String codes(char ch){
		if(ch == '1'){
			return "abc";
		}else if(ch=='2'){
			return "def";
		}else if(ch=='3'){
			return "ghi";
		}else if(ch=='4'){
			return "jkl";
		}else if(ch=='5'){
			return "mno";
		}else if(ch=='6'){
			return "pqr";
		}else if(ch=='7'){
			return "stu";
		}else if(ch=='8'){
			return "vwx";
		}else if(ch=='9'){
			return "yz";
		}else if(ch=='0'){
			return "+;-";
		}else{
			return "";
		}
		
	}

}
