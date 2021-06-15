import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int N, int row, int col, String asf){
        if(row == N) {
            if(qpsf == N) {
                System.out.println(asf);
            }
            return;
        }
        
        
        if(col == N-1) {
            //yes
            queensCombinations(qpsf+1,N,row+1,0,asf + "q\n");
            
            //no
            queensCombinations(qpsf,N,row+1,0,asf + "-\n");
        }
        else {
            //yes
            queensCombinations(qpsf+1,N,row,col+1,asf + "q");
            
            //no
            queensCombinations(qpsf,N,row,col+1,asf + "-");
        }
        
        
    
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}