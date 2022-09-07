import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int a = phone_book.length-1 ; a > 0 ;a--){
            if(phone_book[a].startsWith(phone_book[a-1])){
                return false;
            }
        }

        return answer;
    }
}
