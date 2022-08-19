import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
       int answer = 0;
        int length = nums.length;
        HashSet<Integer> hashSet = new HashSet();
        //해쉬셋에 담기
        for(int a = 0; a < length; a++){
            hashSet.add(nums[a]);
        }
        //가져갈 수 있는 마리의 개수 구하기
        if(length/2>hashSet.size()){
            answer = hashSet.size();
        }else {
            answer = length/2;
        }

        return answer;
    }
}
