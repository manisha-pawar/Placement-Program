//GFG Problem solution https://practice.geeksforgeeks.org/problems/maximum-path-sum/1

class Tree {
    public class Pair {
        int l2lmps; //leaf to leaf maximum path sum
        int n2lmps; //node to leaf maximum path sum

        Pair() {

        }

        Pair(int l2lmps, int n2lmps) {
            this.l2lmps = l2lmps;
            this.n2lmps = n2lmps;
        }
    }

    public Pair helper(Node node) {
        if (node == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        } else if (node.left == null && node.right == null) {
            return new Pair(Integer.MIN_VALUE, node.data);
        }

        Pair lp = helper(node.left);
        Pair rp = helper(node.right);

        int n2L = Math.max(lp.n2lmps, rp.n2lmps) + node.data;

        int factor = Integer.MIN_VALUE;
        if (node.left != null && node.right != null) {
            factor = lp.n2lmps + node.data + rp.n2lmps;
        }

        int L2L = Math.max(Math.max(lp.l2lmps, rp.l2lmps), factor);

        return new Pair(L2L, n2L);
    }


    int maxPathSum(Node root) {
        // code here

        Pair rp = helper(root);

        if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
            return Math.max(rp.l2lmps, rp.n2lmps);
        }

        return rp.l2lmps;
    }
}