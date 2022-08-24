import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

		HashMap<String, Integer> playerList = new HashMap<>();

        // 참가자 추가
		for (String part : participant) {
            playerList.compute(part, (k,v) -> (v == null) ? 1 : v+1);
		}

        // 완주자 제거
		for (String comp : completion) {
            playerList.compute(comp, (k,v) -> v-1);
		}
		
        // COUNT가 0이 아닌 사람이 완주하지 못한 선수
		for(String part : participant) {
			if(playerList.get(part) != 0)
				answer = part;
		}
		return answer;
    }
}