import java.io.*;
import java.util.*;

public class Main{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        postfix_evaluation_conversions(exp);
    }
 
    public static void postfix_evaluation_conversions(String postfix) {
        Stack<Integer>eval = new Stack<>();
        Stack<String>in = new Stack<>();
        Stack<String>pre = new Stack<>();
        
        for(int i=0; i < postfix.length();i++) {
            char ch = postfix.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                eval.push(ch-'0');
                pre.push(ch + "");
                in.push(ch + "");
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                //eval stack value
                char opr = ch;
                int v2 = eval.pop();
                int v1 = eval.pop();
                
                int val = operation(opr,v1,v2);
                eval.push(val);
                
                //pre stack value
                String preV2 = pre.pop();
                String preV1 = pre.pop();
                
                String preval = opr + preV1 + preV2;
                pre.push(preval);
                
                //in stack value
                String inV2 = in.pop();
                String inV1 = in.pop();
                
                String inval = "(" + inV1 + opr + inV2 + ")";
                in.push(inval);
            }
        }
        
        System.out.println(eval.peek());
        System.out.println(in.peek());
        System.out.println(pre.peek());
        
    }
    
    
    public static int operation(char opr,int v1,int v2) {
        if(opr == '+') {
            return v1+v2;
        }
        else if(opr == '-') {
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