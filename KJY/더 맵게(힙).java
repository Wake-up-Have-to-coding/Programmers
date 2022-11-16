import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int f_sv = 0; //첫 스코빌
        int s_sv = 0; //둘 스코빌
        
        PriorityQueue<Integer> scList= new PriorityQueue<>();
        
        for(int sc : scoville){
            if(sc < K){
                scList.add(sc);
            }
        }
        
        //가장 작은 값이 k보다 작으면  
        while(scList.peek() < K){
            answer++; //시간은 흐른다~
            try{
                f_sv = scList.poll();
                s_sv = scList.poll();
            }catch(Exception e){
                return -1;
            }
            scList.add(f_sv + (s_sv * 2));
        }
        
        return answer;
    }
}