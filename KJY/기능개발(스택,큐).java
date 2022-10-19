import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> durations = new LinkedList<>();
        int size = progresses.length;
        
        // durations : 7, 3, 9
        for(int i=0; i<size; i++){
            int remain = 100 - progresses[i];
            int speed = speeds[i];
            int duration = remain / speed;
            if(remain % speed >0) duration++;
            durations.add(duration);
        }
        
        //첫 번째 기능은 무조건 배포일
        int deployDate = durations.poll();
        int functions = 1;
        //배포 
        for(int i=1; i<size; i++){
            int nextDate = durations.poll();
            //기존 기능이 더 빨리 완성되면
            if(deployDate < nextDate){
                answer.add(functions);
                functions=1;  
                deployDate = nextDate; 
            }else{
                functions++; 
            }
        }
        answer.add(functions);   
        
        return answer;
    }
}