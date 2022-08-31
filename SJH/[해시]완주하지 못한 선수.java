import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashmap  = new HashMap<String, Integer>();
        //완주한 사람 hashmap 에 넣기
        //완주한 사람이 참가자 보다 작기때문에 
        for (int i = 0 ; i < completion.length ; i++){
            if(hashmap.containsKey(completion[i])){
                //hashmap.replace(completion[i],hashmap.get(completion[i])+1);
                hashmap.put(completion[i],hashmap.get(completion[i])+1);
            } else {
                hashmap.put(completion[i],1);
            }
        }
        //참가자로 비교해서 없는 이름 찾기
        for(int i = 0 ; i < participant.length ; i++){
            if(hashmap.containsKey(participant[i])){
                if(hashmap.get(participant[i]) > 1){
                    //hashmap.replace(participant[i],hashmap.get(participant[i])-1);
                    hashmap.put(participant[i],hashmap.get(participant[i])-1);
                } else {
                    hashmap.remove(participant[i]);
                }
            } else {
                answer = participant[i];
                return answer;
            }
        }
        
        return answer;
    }
}

//목적 : 완주하지 못한 선수의 이름을 선별
//참가자 중에 동명이인 있을 수 있다.
