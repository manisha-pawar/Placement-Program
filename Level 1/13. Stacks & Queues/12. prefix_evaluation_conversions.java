import java.io.*;
import java.util.*;

public class Main{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        prefix_evaluation_conversions(exp);
    }
 
    public static void prefix_evaluation_conversions(String prefix) {
        Stack<Integer>eval = new Stack<>();
        Stack<String>in = new Stack<>();
        Stack<String>post = new Stack<>();
        
        for(int i=prefix.length()-1; i >= 0;i--) {
            char ch = prefix.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                eval.push(ch-'0');
                in.push(ch+"");
                post.push(ch+"");
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                //eval stack val
                char opr = ch;
                int v1 = eval.pop();
                int v2 = eval.pop();
                int ans = operation(opr,v1,v2);
                eval.push(ans);
                
                //infix stack val
                String inV1 = in.pop();
                String inV2 = in.pop();
                String inval = "(" + inV1 + opr + inV2 + ")";
                in.push(inval);
                
                //postfix stack val
                String postV1 = post.pop();
                String postV2 = post.pop();
                String postval = postV1 + postV2 + opr;
                post.push(postval);
            }
        }
        
        System.out.println(eval.peek());
        System.out.println(in.peek());
        System.out.println(post.peek());
    }
 
    public static int operation(char opr,int v1,int v2) {
        if(opr == '+') {
            return v1+v2;
        }
        else if(opr == '-'){
            return v1-v2;
        }
        else if(opr == '*') {
            return v1*v2;
        }
        else if(opr == '/') {
            return v1/v2;
        }
        else {
            return 0;
        }
    }
 
 
}