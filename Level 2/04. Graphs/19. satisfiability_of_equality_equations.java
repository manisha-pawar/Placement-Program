// leetcode 990 https://leetcode.com/problems/satisfiability-of-equality-equations/

class Solution {
    
    int[]parent;
    int[]rank;
    
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        for(int i=0; i < 26;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        //perform dsu on == equations
        for(int i=0; i < equations.length;i++) {
            String eq = equations[i];
            
            if(eq.charAt(1) == '=') {
                char op1 = eq.charAt(0);
                char op2 = eq.charAt(3);
                
                int l1 = find(op1-'a');
                int l2 = find(op2-'a');

                if(l1 != l2) {
                    //merge

                    if(rank[l1] < rank[l2]) {
                        parent[l1] = l2;
                    }
                    else if(rank[l1] > rank[l2]) {
                        parent[l2] = l1;
                    }
                    else {
                        parent[l1] = l2;
                        rank[l2]++;
                    }
                }
            }
                   
        }
            
            
        for(int i=0; i < equations.length;i++) {
            String eq = equations[i];
            
            if(eq.charAt(1) == '!') {
                char op1 = eq.charAt(0);
                char op2 = eq.charAt(3);
                
                 int l1 = find(op1-'a');
                 int l2 = find(op2-'a');
                
                 if(l1 == l2) {
                     return false;
                 }
            }
        }
            
        return true;
            
    }
    
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        else {
            int temp = find(parent[x]);
            parent[x] = temp;
            return temp;
        }
    }
}