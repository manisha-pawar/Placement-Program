//smallest subarray with all occurrences of the most frequent element

import java.util.*;

public class Main {

    public static void solution(int[] arr) {
        // write your code here
        
        HashMap<Integer,Integer>map = new HashMap<>(); //freq map
        HashMap<Integer,Integer>lo = new HashMap<>(); //last occ
        HashMap<Integer,Integer>fo = new HashMap<>(); //first occ
        
        for(int i=0; i < arr.length;i++) {
            int ele = arr[i];
            
            if(map.containsKey(ele) == false) {
                map.put(ele,1);
                fo.put(ele,i);
                lo.put(ele,i);
            }
            else {
                int nf = map.get(ele) + 1;
                map.put(ele,nf);
                lo.put(ele,i);
            }
        }
        
        int hf = 0; //highest freq
        for(int key : map.keySet()) {
            if(map.get(key) > hf) {
                hf = map.get(key);
            }
        }
        
        //create ans
        int st = -1;
        int et = -1;
        int len = Integer.MAX_VALUE;
        
        for(int key : map.keySet()) {
            if(map.get(key) == hf) {
                int s = fo.get(key);
                int e = lo.get(key);
                int ws = e - s + 1;
                
                if(ws < len) {
                    len = ws;
                    st = s;
                    et = e;
                }
                else if(ws == len) {
                    if(st > s) {
                        len = ws;
                        st = s;
                        et = e;
                    }
                }
            }
        }
        
        System.out.println(arr[st]);
        System.out.println(st);
        System.out.println(et);
       
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
                solution(arr);
	}

}
