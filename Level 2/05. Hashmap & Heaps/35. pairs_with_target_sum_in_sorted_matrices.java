import java.util.*;

public class Main {
	
    public static int solve(int[][] num1, int[][] num2, int tar) {
		// write your code here
        
        int n1 = num1.length;
        int m1 = num1[0].length;
        
        int n2 = num2.length;
        int m2 = num2[0].length;
        
        int b1 = 0;
        int b2 =  n2*m2 - 1;
        
        int count = 0;
        
        //distinct pairs
        // while(b1 < n1*m1 && b2 >= 0) {
        //     int i1 = b1 / m1; 
        //     int j1 = b1 % m1;
            
        //     int i2 = b2 / m2;
        //     int j2 = b2 % m2;
            
        //     if(num1[i1][j1] + num2[i2][j2] == k) {
        //         count++;
        //         b1++;
        //         b2--;
        //     }
        //     else if(num1[i1][j1] + num2[i2][j2] < k) {
        //         b1++;
        //     }
        //     else {
        //         b2--;
        //     }
        // }
        
        
        
        //non distinct pairs
        HashMap<Integer,Integer>map1 = new HashMap<>();
        HashMap<Integer,Integer>map2 = new HashMap<>();
        
    
        for(int i=0; i < n1;i++) {
            for(int j=0; j < m1;j++) {
                int nf = map1.getOrDefault(num1[i][j] , 0) + 1;
                map1.put(num1[i][j],nf);
            }
        }
        
        for(int i=0; i < n2;i++) {
            for(int j=0; j < m2;j++) {
                int nf = map2.getOrDefault(num2[i][j] , 0) + 1;
                map2.put(num2[i][j],nf);
            }
        }
        
        
        for(int key : map2.keySet()) {
            int remtar = tar - key; //remaining target
                
            if(map1.containsKey(remtar)) {
                count += map1.get(remtar) * map2.get(key);
            }
            
        }
        
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] mat1 = new int[N][N];
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				mat1[i][j] = sc.nextInt();
			}
		}

		int[][] mat2 = new int[N][N];
		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
				mat2[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		System.out.println(solve(mat1, mat2, K));

	}

}
