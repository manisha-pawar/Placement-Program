import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        boolean ans = balanced(str);
        System.out.println(ans);
    }
    
    public static boolean balanced(String str) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i < str.length();i++) {
            char ch = str.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else if(ch == ')') {
                if(st.size() == 0) {
                    //extra closing
                    return false;
                }
                else if(st.peek() != '(') {
                    //mismatch
                    return false;
                }
                else {
                    st.pop();
                }
            }
            else if(ch == '}') {
                if(st.size() == 0) {
                    //extra closing
                    return false;
                }
                else if(st.peek() != '{') {
                    //mismatch
                    return false;
                }
                else {
                    st.pop();
                }
            }
            else if(ch == ']') {
                if(st.size() == 0) {
                    //extra closing
                    return false;
                }
                else if(st.peek() != '[') {
                    //mismatch
                    return false;
                }
                else {
                    st.pop();
                }
            }
        }
        
        if(st.size() == 0 ) {
            return true;
        }
        else {
            //extra opening brackets
            return false;
        }
    }

}