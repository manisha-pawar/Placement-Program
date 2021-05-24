import java.io.*;
import java.util.*;

public class Main{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        int ans = infix_evaluation(exp);
        System.out.println(ans);
    }
 
    public static int infix_evaluation(String exp) {
        Stack<Character>oprtr = new Stack<>();
        Stack<Integer>oprnd = new Stack<>();
        
        for(int i=0;i < exp.length();i++) {
            char ch = exp.charAt(i);
            
            if(ch == '(') {
                oprtr.push(ch);
            }
            else if(ch >= '0' && ch <= '9') {
                oprnd.push(ch-'0');
            }
            else if(ch == ')') {
                //evaluate till '('
                while(oprtr.peek() != '(') {
                    char opr = oprtr.pop();
                    int v2 = oprnd.pop();
                    int v1 = oprnd.pop();
                    
                    int ans = operation(opr,v1,v2);
                    oprnd.push(ans);
                }
                oprtr.pop(); // pop out '('
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch =='/') {
                while(oprtr.size() > 0 && oprtr.peek() != '(' && precedence(ch) <= precedence(oprtr.peek())) {
                    char opr = oprtr.pop();
                    int v2 = oprnd.pop();
                    int v1 = oprnd.pop();
                    
                    int ans = operation(opr,v1,v2);
                    oprnd.push(ans);
                }
                oprtr.push(ch);
            }
            
        }
        
        while(oprtr.size() != 0) {
            char opr = oprtr.pop();
            int v2 = oprnd.pop();
            int v1 = oprnd.pop();
            
            int ans = operation(opr,v1,v2);
            oprnd.push(ans);
        }
        
        return oprnd.peek();
        
    }
    
    public static int operation(char opr,int v1,int v2) {
        if(opr == '+') {
            return v1+v2;
        }
        else if(opr == '/') {
            return v1/v2;
        }
        else if(opr == '*') {
            return v1*v2;
        }
        else if(opr == '-') {
            return v1-v2;
        }
        else {
            return 0;
        }
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