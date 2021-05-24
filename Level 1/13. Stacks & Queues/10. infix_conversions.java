import java.io.*;
import java.util.*;

public class Main{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        infix_conversions(exp);
    }
 
    public static void infix_conversions(String infix) {
        Stack<Character>oprtr = new Stack<>();
        Stack<String>pre = new Stack<>();
        Stack<String>post = new Stack<>();
        
        for(int i=0; i < infix.length();i++) {
            char ch = infix.charAt(i);
            
            if(ch == '(') {
                oprtr.push(ch);
            }
            else if(ch == ')') {
                while(oprtr.peek() != '(') {
                    char opr = oprtr.pop();
                    
                    //create pre value
                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    String preval = opr + preV1 + preV2;
                    
                    pre.push(preval);
                    
                    //create post value
                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    String postval = postV1+postV2+opr;
                    
                    post.push(postval);
                }
                oprtr.pop();
            }
            else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                pre.push(ch + "");
                post.push(ch + "");
            }
            else if(ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                while(oprtr.size() > 0 && oprtr.peek() != '(' && precedence(ch) <= precedence(oprtr.peek())) {
                    char opr = oprtr.pop();
                    
                    //create pre value
                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    String preval = opr + preV1 + preV2;
                    
                    pre.push(preval);
                    
                    //create post value
                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    String postval = postV1+postV2+opr;
                    
                    post.push(postval);
                }
                oprtr.push(ch);
            }
        }
        
        while(oprtr.size() > 0) {
            char opr = oprtr.pop();
                    
            //create pre value
            String preV2 = pre.pop();
            String preV1 = pre.pop();
            String preval = opr + preV1 + preV2;
            
            pre.push(preval);
            
            //create post value
            String postV2 = post.pop();
            String postV1 = post.pop();
            String postval = postV1+postV2+opr;
            
            post.push(postval);
        }
        
        System.out.println(post.peek());
        System.out.println(pre.peek());
    }
    
    public static int precedence(char opr) {
        if(opr == '+' || opr == '-') {
            return 1;
        }
        else if(opr == '*' || opr == '/') {
            return 2;
        }
        else {
            return 0;
        }
    }
}