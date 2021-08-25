import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        
        HashMap<String,Integer>map = new HashMap<>(); //state vs first index
        
        int ans = 0;
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        
        
        map.put("0@0",-1);
        
        for(int i=0; i < arr.length;i++) {
            if(arr[i] == 0) {
                c0++;
            }
            else if(arr[i] == 1) {
                c1++;
            }
            else {
                c2++;
            }
            
            String st = (c1 - c0) + "@" + (c2 - c1);
            
            if(map.containsKey(st) == true) {
                int len = i - map.get(st);
                
                if(len > ans) {
                    ans = len;
                }
            }
            else {
                map.put(st,i);
            }
        }
        
        return ans;
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
