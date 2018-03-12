import java.lang.reflect.Array;
import java.util.ArrayList;

public class IntersectionoftwoArrays {
	
	public static void main(String[] args){
		 int[] one = {1,1,2,2,2,3,5};
		 int[] two = {1,1,1,2,2,4,5};
		 
		 ArrayList<Integer> arr = intersection(one,two);
		 System.out.println(arr);
	}
	
	public static ArrayList<Integer> intersection(int one[],int two[]){
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0,j = 0;
		
		while(true){
			if(i==one.length || j == two.length){
				break;
			}
			
			if(one[i] == two[j]){
				list.add(one[i]);
				i++;
				j++;
			}else if(one[i]>two[j]){
				j++;
			}else{
				i++;
			}
		}
		
		return list;
		
	}

}
