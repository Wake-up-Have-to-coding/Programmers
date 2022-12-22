import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<length; i++){
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                list.add(array[j]);
            }
            
            Collections.sort(list);
            answer[i] = list.get(commands[i][2]-1);
            
            list.clear();
            
        }
        return answer;
    }
}