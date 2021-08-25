import java.util.*;

public class Main {

	public static int solution(int[] arr, int k){
		// write your code here
		
		HashMap<Integer,Integer>map = new HashMap<>(); //ps vs freq
		int count = 0;
		int ps = 0;
		
		map.put(0,1);
		
		for(int i=0; i < arr.length;i++) {
		    ps += arr[i];
		    
		    if(map.containsKey(ps-k) == true) {
		        count += map.get(ps-k);
		    }
		    
		    if(map.containsKey(ps) == false) {
		        map.put(ps,1);
		    }
		    else {
		        int nf = map.get(ps) + 1;
		        map.put(ps,nf);
		    }
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}

}
