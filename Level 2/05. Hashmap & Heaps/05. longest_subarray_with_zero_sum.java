import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		// write your code here
        HashMap<Integer,Integer>map = new HashMap<>();
        
        int ans = 0;
        int ps = 0;
        
        map.put(0,-1);
        
        for(int k=0; k < arr.length;k++) {
            ps += arr[k];
            
            if(map.containsKey(ps) == false) {
                map.put(ps,k);
            }
            else {
                int len = k - map.get(ps);
                if(len > ans) {
                    ans = len;
                }
            }
        }
        
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
