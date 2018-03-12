package lecture1_Recursion;

public class replacingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "apixvpicpirpid";
//		changepi(str,"");
		

	}
	
	public static void changepi(String str,String ans){
		if(str.length()==0){
			System.out.println(ans);
			return;
		}
		
		char ch = str.charAt(0);
		String sub = str.substring(1);
		
		if(ch =='p' && sub.charAt(0) == 'i'){
			sub = sub.substring(1);
			changepi(sub,ans+"3.14");
		}else{
			changepi(sub,ans+ch);
		}
	}	
}
