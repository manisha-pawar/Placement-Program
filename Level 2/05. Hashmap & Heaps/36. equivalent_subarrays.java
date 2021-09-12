import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
		//write your code here
		
		int count = equivalent_subarrays(arr);
		System.out.println(count);
	}
	
	public static int equivalent_subarrays(int[]arr) {
	    int count = 0;
	    
	    HashMap<Integer,Integer>map = new HashMap<>();
	    HashSet<Integer>hs = new HashSet<>();
	    
	    for(int val : arr) {
	        hs.add(val);
	    }
	    
	    int i = -1;
	    int j = -1;
	    
	    while(i < arr.length - 1) {
	        //aquire
	        while(i < arr.length - 1) {
	            i++;
	            int ele = arr[i];
	            
	            int nf = map.getOrDefault(ele,0) + 1;
	            map.put(ele,nf);
	            
	            if(map.size() == hs.size()) {
	                count += arr.length - i;
	                break;
	            }
	        }
	        
	        //release
	        while(j < i && map.size() == hs.size()) {
	            j++;
	            int ele = arr[j];
	            
	            if(map.get(ele) == 1) {
	                map.remove(ele);
	                break;
	            }
	            else {
	                int nf = map.get(ele) - 1;
	                map.put(ele,nf);
	                count += arr.length - i;
	            }
	        }
	    }
	    
	    
	    return count;
	     
	}


}
