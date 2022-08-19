import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // n/2마리
        int pocket = (nums.length)/2;
        
        Set<Integer> set = new HashSet<Integer>();
        // 중복 제거
        for(int num : nums){
            set.add(num);
        }
        
        int size = set.size();
        // 폰켓몬 종류가 n/2마리보다 같거나 적으면 무조건 종류 개수가 답
        if(size <= pocket){
            answer = size;
        }else{ //많을 경우, n/2 종류 고를 수 있음
            answer = pocket;
        }
        
        return answer;
    }
}