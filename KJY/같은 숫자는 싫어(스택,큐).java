import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        int front = -1;
        int back = -1;
        
        for(int i=0; i<arr.length; i++){
            back = arr[i];
            if(i==0){
                answer.add(back);
            }else{
                if(front != back){
                    answer.add(back);
                }
            }
            front = back;
        }

        return answer;
    }
}