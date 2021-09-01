import java.util.*;

public class Main {
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
		// write your code here

        HashMap<Integer,ArrayList<Integer>>epmap = new HashMap<>(); //ele vs positions in arr2
        
        for(int i = arr2.length-1;i >= 0;i--) {
            if(epmap.containsKey(arr2[i]) == false) {
                ArrayList<Integer>list = new ArrayList<>();
                list.add(i);
                epmap.put(arr2[i],list);
            }
            else {
                ArrayList<Integer>list = epmap.get(arr2[i]);
                list.add(i);
            }
        }
        
        
        int[]ans = new int[arr1.length];
        
        for(int i=0; i < arr1.length;i++) {
            ArrayList<Integer>list = epmap.get(arr1[i]);
            int pos = list.get(list.size()-1);
            ans[i] = pos;
            list.remove(list.size()-1);
        }
         
		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}
