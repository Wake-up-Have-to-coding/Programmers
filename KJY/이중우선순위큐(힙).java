import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        
        List<Integer> list = new ArrayList<>();
        
        for(String oper : operations){
            String[] temp = oper.split(" ");
            
            String word = temp[0];
            int num = Integer.parseInt(temp[1]);
            
            switch(word){
                case "I":
                    list.add(num);
                    break;
                case "D":
                    if(list.size()!=0){
                        if(num == 1){
                            int max = Collections.max(list);
                            int index = list.indexOf(max);
                            list.remove(index);
                        }else if(num == -1){
                            int min = Collections.min(list);
                            int index = list.indexOf(min);
                            list.remove(index);
                        }
                    }
                    break;
            }
        }
        
        if(list.size()!= 0){
            int max = Collections.max(list);
            int min = Collections.min(list);
            
            answer[0] = max;
            answer[1] = min;
        }
        
        return answer;
    }
}