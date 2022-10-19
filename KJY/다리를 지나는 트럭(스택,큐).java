import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 경과 시간
        int crossedCnt = 0; // 건넌 트럭 개수
        int index = 0; // 무게 비교를 위한 곧 건널 트럭의 인덱스
        int totalWeight = 0; // 현재 다리에 올라와 있는 트럭의 총 무게
        
        Queue<Integer> bridge = new LinkedList<>(); //다리를 queue로 생각

        int number_of_truck = truck_weights.length; //처음에 세팅된 건널 트럭 개수
        
        while(!(crossedCnt == number_of_truck)){
            // System.out.println("### answer : " + answer);
            answer++; //다리를 건너든 안건너든 시간은 간다..
            
            // System.out.println("before : " + bridge);
        
            if(bridge.size() == bridge_length){
                if(bridge.peek() != 0){ //트럭이 다리를 건넜을 경우
                    crossedCnt++; //건넌 트럭 count up
                }
                totalWeight -= bridge.poll(); // 다리가 견디고 있는 무게에서 건넌 트럭 무게 빼주기
                // 트럭이 건너지 않아도 0으로 무게에 영향없어서 그냥 queue에서 뺄 겸 같이 poll해줌
            }
             // System.out.println("crossedCnt : " + crossedCnt);
             // System.out.println("after : " + bridge);
             // System.out.println("totalWeight : " + totalWeight);
            
            // (다리에 올라가있는 트럭의 무게 + 건널 트럭 무게)가 다리가 견딜 수 있는 무게까지일 경우
            if((index < number_of_truck) && totalWeight + truck_weights[index] <= weight){
                int t_weight = truck_weights[index];
                bridge.offer(t_weight); //다리에 트럭 추가
                totalWeight += t_weight; //추가된 트럭 무게 추가
                index++;
            }else{
                bridge.offer(0); // 건너는 트럭이 없을 경우 그 자리에 0을 넣어줌
            }
        }
        
        return answer;
    }
    
}