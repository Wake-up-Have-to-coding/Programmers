import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> type = new HashMap<>();
        
        for(String[] cloth : clothes){
            type.compute(cloth[1], (k,v) -> (v == null) ? 1 : v+1);
        }
        
        // 각 종류의 개수 + 입지 않았을 경우 (a+1) * (b+1)...
        for(Integer value : type.values()){
            answer = answer * (value + 1);
        }
        
        // 아무것도 입지 않았을 경우 제외
        return answer-1;
    }
}