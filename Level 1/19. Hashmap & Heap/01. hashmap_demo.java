import java.util.*;

public class Main {
    
    public static void main(String[]args) {
        //hashmap declaration
        HashMap<String,Integer>hm = new HashMap<>();
        
        //put -> insertion
        hm.put("India",48);
        hm.put("Pak",38);
        hm.put("Europe",50);
        hm.put("Ireland",80);
        
        System.out.println(hm);
        
        //put -> updation
        hm.put("India",100);
        
        System.out.println(hm);
        
        //get
        System.out.println(hm.get("Pak")); //when key is present -> value
        System.out.println(hm.get("England")); //when key is absent -> null
        
        //containsKey
        System.out.println(hm.containsKey("Pak")); //when key is present -> true
        System.out.println(hm.containsKey("England")); //when key is absent -> false
        
        //keySet
        ArrayList<String>keys = new ArrayList<>(hm.keySet());
        System.out.println(keys);
        
        //remove
        System.out.println(hm);
        hm.remove("India");
        System.out.println(hm);
        
        //travel hashmap
        // Set<String>ks = hm.keySet();
        
        // for(String key : ks) {
        //     System.out.println(key + " " + hm.get(key));
        // }
        
        for(int i=0; i < keys.size();i++) {
            String key = keys.get(i);
            System.out.println(key + " " + hm.get(key));
        }
        
    }
}