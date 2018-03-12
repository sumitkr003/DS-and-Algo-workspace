package Lecture2_Recursion;

import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
//		
//		ArrayList<String> ans =  permutation(str);
//		System.out.println(ans);
		
		System.out.println(permutation2(str));

	}

	private static ArrayList<String> permutation(String str) {
		//base case
		if(str.length()==0){
			ArrayList<String> x = new ArrayList<>();
			x.add("");
			return x;
		}
		
		ArrayList<String> ans = new ArrayList<>();
		char ch = str.charAt(0);
		str = str.substring(1);
		
		ArrayList<String> mr = permutation(str);
		for(String s:mr){
			for(int i = 0;i<=s.length();i++){
				ans.add(s.substring(0, i) + ch + s.substring(i));
			}
		}
		return ans;
	}
	
	private static String permutation2(String str){
		if(str.length()==1){
			return str;
		}
		
		char ch = str.charAt(0);
		str = str.substring(1);
		String s = permutation2(str);
		String ans="";
		for(int i = 0;i<str.length();i++){
			ans+= s.substring(0,i) + ch + s.substring(i)+" ";
		}
		
		return ans;
		
	}
	
	

}
