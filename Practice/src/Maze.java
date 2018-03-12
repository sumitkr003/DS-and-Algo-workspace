import java.util.ArrayList;

public class Maze {

	public static void main(String[] args) {
		System.out.println(mazepath(0,0,2,2));

	}
	
	public static ArrayList<String> mazepath(int cr,int cc,int er,int ec){
		if(cr==er && cc==ec){
			ArrayList<String> n = new ArrayList<>();
			n.add("");
			return n;
		}else if(cr>er || cc>ec){
			ArrayList<String> n = new ArrayList<>();
			return n;
		}
		
		ArrayList<String> path = new ArrayList<>();
		
		ArrayList<String> rh = mazepath(cr+1,cc,er,ec);
		for(String str:rh){
			path.add("H"+str);
		}
		
		ArrayList<String> rv = mazepath(cr,cc+1,er,ec);
		for(String str:rv){
			path.add("V"+str);
		}
		
		ArrayList<String> rd = mazepath(cr+1,cc+1,er,ec);
		for(String str:rd){
			path.add("D"+str);
		}
		
		return path;
	}

}
