public class AVL {
    public static class Node {
        int val;
        Node left;
        Node right;
        int ht = 0;
        int bal = 0;

        Node() {

        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static Node add(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (node.val < data) {
            node.right = add(node.right, data);
        } else if (node.val > data) {
            node.left = add(node.left, data);
        } else {
            //do nothing, node of val 'data' already exists
        }

        updateHtBal(node);

        //if bal is safe or not
        node = checkAndWork(node);

        return node;
    }


    public static Node remove(Node node,int data) {
        if(node == null) {
            return null;
        }

        if(node.val < data) {
            node.right = remove(node.right,data);
        }
        else if(node.val > data) {
            node.left = remove(node.left,data);
        }
        else {
            //no child
            if(node.left == null && node.right == null) {
                return null;
            }
            //only right child
            else if(node.left == null) {
                return node.right;
            }
            //only left child
            else if(node.right == null) {
                return node.left;
            }
            //both child
            else {
                int lmax = max(node.left);
                node.val = lmax;
                node.left = remove(node.left,lmax);
            }

        }

        updateHtBal(node);

        //if bal is safe or not
        node = checkAndWork(node);

        return node;
    }

    public static int max(Node node) {
        if(node.right != null) {
            return max(node.right);
        }
        else {
            return node.val;
        }
    }
    public static Node rightRotation(Node A) {
        Node B = A.left;

        Node B_right = B.right;
        B.right = A;
        A.left = B_right;

        updateHtBal(A);
        updateHtBal(B);

        return B;
    }

    public static Node leftRotation(Node A) {
        Node B = A.right;

        Node B_left = B.left;
        B.left = A;
        A.right = B_left;

        updateHtBal(A);
        updateHtBal(B);

        return B;
    }

    public static Node solveRR(Node node) {
        return leftRotation(node);
    }

    public static Node solveLL(Node node) {
        return rightRotation(node);
    }

    public static Node checkAndWork(Node node) {
        
        if(node.bal == 2) {
            //LL
            if(node.left.bal == 1) {
                return solveLL(node);
            }
            //LR
            else {
                node.left = solveRR(node.left);
                return solveLL(node);
            }
        }
        else if(node.bal == -2) {
            //RR
            if(node.right.bal == -1) {
               return solveRR(node);
            }
            //RL
            else {
                node.right = solveLL(node.right);
                return solveRR(node);
            }
        }

        return node;
    }

    public static void updateHtBal(Node node) {
        int lh = (node.left == null) ? -1 : node.left.ht;
        int rh = (node.right == null) ? -1 : node.right.ht;

        int ht = Math.max(lh,rh) + 1;
        int bal = lh - rh;

        node.ht = ht;
        node.bal = bal;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.val + "";
        str += " <- " + node.val + " -> ";
        str += node.right == null ? "." : node.right.val + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {

        int[] arr = {
            10,
            20,
            30,
            30,
            50,
            60,
            70,
            90,
            100
        };

        Node root = null;

        for(int ele : arr) {
            root = add(root,ele);
        }

        add(root,32);
        add(root,62);
        add(root,34);

        display(root);
        
        System.out.println("------------------------------------");

        root = remove(root,34);
        root = remove(root,10);

        display(root);
    }
}