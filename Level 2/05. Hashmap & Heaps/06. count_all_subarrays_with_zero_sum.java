import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		// write your code here
        
        HashMap<Integer,Integer>map = new HashMap<>();
        int count = 0;
        int ps = 0;
        
        map.put(0,1);
        
        for(int i=0; i < arr.length;i++) {
            ps += arr[i];
            
            if(map.containsKey(ps) == false) {
                map.put(ps,1);
            }
            else {
                count += map.get(ps);
                map.put(ps,map.get(ps)+1);
            }
        }
        
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));

	}

}
