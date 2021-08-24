import java.util.*;

public class Main {
	
	public static void solution(int[] arr, int k){
		//write your code here
        
        HashMap<Integer,Integer>map = new HashMap<>(); //remainder-freq-map
        
        for(int i=0; i < arr.length;i++) {
            int rem = arr[i] % k;
            
            if(rem < 0) {
                rem = rem + k;
            }
            
            if(map.containsKey(rem) == false) {
                map.put(rem,1);
            }
            else {
                int nf = map.get(rem) + 1;
                map.put(rem,nf);
            }
        }
        
        boolean ans = true;
        
        //travel on map
        for(int rem : map.keySet()) {
            int freq = map.get(rem);
            
            if(rem == 0) {
                if(freq % 2 != 0) {
                    ans = false;
                    break;
                }
            }
            else if(k % 2 == 0 && rem == k/2) {
                if(freq % 2 != 0) {
                    ans = false;
                    break;
                }
            }
            else {
                int comp = k - rem;
                
                if(map.containsKey(comp) == false || map.get(comp) != freq) {
                    ans = false;
                    break;
                } 
            }
         }
        
         System.out.println(ans);
         
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}
