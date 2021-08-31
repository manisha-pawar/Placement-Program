import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		// write your code here
        
        int ans = 0;
        
        for(int i=0; i < arr.length;i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            
            HashSet<Integer>hs = new HashSet<>();
            
            for(int j=i; j < arr.length;j++) {
                
                if(arr[j] < min) {
                    min = arr[j];
                }
                if(arr[j] > max) {
                    max = arr[j];
                }
                
                if(hs.contains(arr[j]) == true) {
                    break;
                }
                hs.add(arr[j]);
                
                int ec = j - i + 1;
                int dc = max - min + 1;
                
                if(ec == dc) {
                    ans = Math.max(ans,ec);
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
