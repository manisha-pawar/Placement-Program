import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        char ch = hfc(str);
        System.out.println(ch);
        
    }
    
    
    public static char hfc(String str) {
        HashMap<Character,Integer>hm = new HashMap<>();
        
        //populate freq map
        for(int i=0; i < str.length();i++) {
            char ch = str.charAt(i);
            
            if(hm.containsKey(ch) == false) {
                hm.put(ch,1);
            }
            else {
                int nf = hm.get(ch) + 1;
                hm.put(ch,nf);
            }
        }
        
        
        int hf = 1;
        char hfc = str.charAt(0);
        
        
        Set<Character>ks = hm.keySet();
        
        for(char key : ks) {
            int val = hm.get(key);
            
            if(val > hf) {
                hf = val;
                hfc = key;
            }
        }
        
        return hfc;
        
        
    }

}