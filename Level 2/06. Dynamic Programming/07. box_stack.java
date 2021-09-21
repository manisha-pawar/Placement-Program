class Solution
{
    static class Box implements Comparable<Box>{
        int l;
        int w;
        int h;
        
        Box() {
            
        }
        
        Box(int l,int w,int h) {
            this.l = l;;
            this.w = w;
            this.h = h;
        }
        
        public int compareTo(Box o) {
            int ta = this.l * this.w;
            int oa = o.l * o.w;
            
            return ta - oa;
        }
    }
    
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        Box[]arr = new Box[3*n];
        int k = 0;
        
        
        for(int i=0; i < n;i++) {
            int a = length[i];
            int b = width[i];
            int c = height[i];
            
            //a,b
            if(a < b) {
                arr[k] = new Box(b,a,c);
            }
            else {
                arr[k] = new Box(a,b,c);
            }
            k++;
            
            //b,c
            if(b < c) {
                arr[k] = new Box(c,b,a);
            }
            else {
                arr[k] = new Box(b,c,a);
            }
            k++;
            
            //a,c
            if(a < c) {
                arr[k] = new Box(c,a,b);
            }
            else {
                arr[k] = new Box(a,c,b);
            }
            k++;
            
        }
        
        //1. sort on the basis of base area
        Arrays.sort(arr);
        
        
        //2. lis on the basis -> l,w
        int mh = 0;
        int[]dp = new int[arr.length];
        for(int i=0; i < arr.length;i++) {
            int max = 0;
            
            for(int j=0; j < i;j++) {
                if(arr[j].l < arr[i].l && arr[j].w < arr[i].w) {
                    max = Math.max(dp[j],max);
                }
            }
            
            dp[i] = max + arr[i].h;
            mh = Math.max(mh,dp[i]);
        }
        
        
        return mh;
    }
}