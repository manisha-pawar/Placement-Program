//https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    static class Pair implements Comparable<Pair>{
        int wt;
        int val;
        double r;
        
        Pair() {
            
        }
        
        Pair(int wt,int val) {
            this.wt = wt;
            this.val = val;
            this.r = (val*1.0) / wt;
        }
        
        //this < o -> -ve
        //this > o -> +ve
        //this == o -> 0
        public int compareTo(Pair o) {
            if(this.r < o.r) {
                return -1;
            }  
            else if(this.r > o.r) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Pair[]a = new Pair[n];
        
        for(int i=0; i < n;i++) {
            Pair p = new Pair(arr[i].weight,arr[i].value);
            a[i] = p;
        }
        
        Arrays.sort(a); //increasing order sorting
        
        int rc = W;
        double profit = 0.0;
        
        for(int i=n-1; i >= 0;i--) {
            Pair p = a[i];
            
            if(p.wt <= rc) {
                //use this item completely
                rc -= p.wt;
                profit += p.val;
            }
            else {
                //use this item partially
                profit += (p.r * rc);
                rc = 0;
                break;
            }
        }
        
        return profit;
        
        
    }
  
}