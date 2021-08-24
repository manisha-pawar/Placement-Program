import java.util.*;

public class Main {

	public static ArrayList<Integer> solution(int[] arr, int k) {
		//write your code here
        
        HashMap<Integer,Integer>map = new HashMap<>();
        ArrayList<Integer>ans = new ArrayList<>();
        
        //work on first window
        int i=0;
        for(i = 0; i < k;i++) {
            if(map.containsKey(arr[i]) == false) {
                map.put(arr[i],1);
            }
            else {
                int nf = map.get(arr[i]) + 1;
                map.put(arr[i],nf);
            }
        }
        
        ans.add(map.size()); //first window ans
        
        i = k-1;
        int j = 0;
        
        //i -> last window's end point
        //j -> last window's start point
        
        while(i < arr.length-1) {
            i++;
            
            //aquiring ith element
            if(map.containsKey(arr[i]) == false) {
                map.put(arr[i],1);
            }
            else {
                int nf = map.get(arr[i]) + 1;
                map.put(arr[i],nf);
            }
            
            //releasing jth element
            int freq = map.get(arr[j]);
            
            if(freq == 1) {
                map.remove(arr[j]);
            }
            else {
                int nf = map.get(arr[j])-1;
                map.put(arr[j],nf);
            }
            j++;
            
            ans.add(map.size());
        }
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}


}
