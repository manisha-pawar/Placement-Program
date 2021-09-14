class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        Integer[]arrI = new Integer[arr.length];  //array of Integer
        
        for(int i = 0; i < arr.length;i++) {    
            arrI[i] = new Integer(arr[i]);
        }
        
        Arrays.sort(arrI, (a,b)-> {
            return Math.abs(a) - Math.abs(b);
        });
        
        
        HashMap<Integer,Integer>map = new HashMap<>();
        
        for(int i = 0; i < arrI.length;i++) {
            int nf = map.getOrDefault(arrI[i],0) + 1;
            map.put(arrI[i],nf);
        }
        
        for(int i=0; i < arrI.length;i++) {
            int e1 = arrI[i];
            int e2 = 2 * arrI[i];
            
            if(e1 == 0) {
                if(map.get(e1) % 2 != 0) {
                    return false;
                }
                continue;
            }
            
            if(map.getOrDefault(e1,0) > 0) {
                int f1 = map.getOrDefault(e1,0);
                int f2 = map.getOrDefault(e2,0);

                if(f2 == 0) {
                    return false;
                }

                map.put(e1,f1-1);
                map.put(e2,f2-1);
            }
            
        }
        
        return true;
    }
}