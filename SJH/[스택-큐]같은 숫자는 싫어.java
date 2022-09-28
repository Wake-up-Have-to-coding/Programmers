import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        //배열에서 연속적으로 나타나는 숫자 제거
        List<Integer> answer_list = new ArrayList<Integer>();
        //int compare = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(i==0){
                answer_list.add(arr[i]); //[1] index=0
            }else{
                //compare = answer_list.get(answer_list.size()-1);
                
                if(answer_list.get(answer_list.size()-1) != arr[i]){
                    answer_list.add(arr[i]);
                }
            }
        }

        return answer_list;
    }
}
