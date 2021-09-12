import java.util.*;

public class Main {

    public static class Pair{
        int sn;
        String name;
        
        Pair() {
            
        }
        
        Pair(int sn,String name) {
            this.sn = sn;
            this.name = name;
        }
        
        @Override
        public String toString() {
            String str = "";
            str  = "(" + this.sn + "-" + this.name + ")";
            
            return str;
        }
        
        @Override
        public boolean equals(Object obj) {
            Pair o = (Pair)obj;
            
            if(this.sn != o.sn || this.name.equals(o.name) == false) {
                return false;
            } 
            
            return true;
        }
        
        @Override
        public int hashCode() {
            return this.sn;
        }
        
    }
    
    public static void main(String[] args) {
    
       
    //   if(p1.equals(p2)) {
    //       System.out.println("Pairs are equal");
    //   }
    //   else {
    //       System.out.println("Pairs are un-equal");
    //   }
       
       
       HashMap<Pair,Integer>map = new HashMap<>();
       
       for(int i=0; i < 5; i++) {
           Pair p1 = new Pair(10,"abc");
           
           if(map.containsKey(p1) == false) {
               map.put(p1,1);
           }
           else {
               int nf = map.get(p1) + 1;
               map.put(p1,nf);
           }
       }
       
       
       System.out.println(map);
       
    }
}