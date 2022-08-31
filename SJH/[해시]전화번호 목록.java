//효율성 테스트 탈락

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
    boolean answer = true;
    Set<String> phone_book_to_set = new HashSet<String>(Arrays.asList(phone_book));

    for (int a = 0; a < phone_book.length; a++) {
        int length = phone_book[a].length();
        String value = phone_book[a];

        if(phone_book_to_set.stream().filter(e -> e.startsWith(value)).count() > 1) return false;
    }
        return answer;
    }
}
