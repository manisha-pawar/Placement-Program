import java.util.*;

public class Main {

    public static class Node {
        int data;
        ArrayList<Node>children = new ArrayList<>();
    }

    public static Node construct(int[]data) {
        Stack<Node>st = new Stack<>();
        Node root = null;

        for(int i=0; i < data.length;i++) {
            int val = data[i];

            if(val == -1) {
                st.pop();
            }
            else {
                //creata a node
                Node n = new Node();
                n.data = val;

                if(st.size() > 0) {
                    st.peek().children.add(n);
                }
                else {
                    //first node
                    root = n;
                }
                st.push(n);
            }
        }

        return root;
    }

    public static void display(Node node) {
        //print node and its children
        System.out.print(node.data + "->");
        for(int i=0 ; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            System.out.print(child.data + ",");
        }
        System.out.println(".");

        //faith on node's children
        for(int i=0 ; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            display(child);
        }
    }

    public static void main(String[]args) {
        int[]arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = construct(arr);
        display(root); // 10 family print ho jaaye
    }
}