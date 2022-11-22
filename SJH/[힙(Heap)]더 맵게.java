import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int lowest_spicy = 0;
        int lower_spicy = 0;
        int mix_spicy = 0;
        
        PriorityQueue<Integer> mix_scoville = new PriorityQueue<Integer>();
        for(int value : scoville){
            mix_scoville.add(value);
        }
        while(true){
            lowest_spicy = mix_scoville.poll();
            if(lowest_spicy < K &&mix_scoville.size()<1){
                answer = -1;
                break;
            }
            if(lowest_spicy >= K){
                break;
            }
            lower_spicy = mix_scoville.poll();
            mix_spicy = lowest_spicy + (lower_spicy * 2);
            answer++;
            mix_scoville.add(mix_spicy);
        }
        return answer;
    }
}
