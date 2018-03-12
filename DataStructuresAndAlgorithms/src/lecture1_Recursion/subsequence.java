package lecture1_Recursion;

public class subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		subsequence(str,"");

	}
	
	public static void subsequence(String str,String ans){
		if(str.length() == 0){
			System.out.println(ans);
			return;
		}
		
		char ch = str.charAt(0);
		str = str.substring(1);
		subsequence(str, ans);
		subsequence(str, ans+ch);
	}

}
