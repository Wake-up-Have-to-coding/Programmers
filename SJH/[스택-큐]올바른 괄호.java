import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int a = 0 ; a < s.length() ; a++ ){
            if(s.charAt(a) == '('){
                stack.push(s.charAt(a));
            }
            else if(s.charAt(a) == ')'){
                if(stack.empty())
                    return false;
                else
                    stack.pop();
            }
        }
        if(!stack.empty())
            return false;

        return answer;
    }
}
