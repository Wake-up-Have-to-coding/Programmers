class Solution {
    boolean solution(String s) {
        char[] c = s.toCharArray();
        int flag = 0;
        
        for(char a : c){
            if(a == '(') flag++;
            else flag--;
            if(flag < 0) return false;
        }
        
        if(flag != 0) return false;
        
        return true;
    }
}