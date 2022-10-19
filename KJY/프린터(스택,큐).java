import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> docs = new LinkedList<>();
        Queue<Integer> prints = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            docs.offer(i);
            prints.offer(priorities[i]);
        }
        
        int head = -1;
        int index = -1;
        
        while(!prints.isEmpty()){
            head = prints.poll();
            index = docs.poll();
            
            for(int value : prints){
                if(head < value){ // 나머지 중 존재
                    prints.offer(head);
                    docs.offer(index);
                    answer--;
                    index = -1; // 뽑지 않으므로
                    break;
                }
            }
            answer++;

            if(index == location) break;
        }
        return answer;
    }
}