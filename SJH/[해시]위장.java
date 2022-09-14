import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1; 
        
        Map<String, Integer> cloth_num = new HashMap<String, Integer>(); //스파이 옷의 종류와 개수
        String[] cloth_type_array;
        for(int a = 0; a < clothes.length; a++){ 
            int num = cloth_num.containsKey(clothes[a][1])?cloth_num.get(clothes[a][1])+1:2;
            cloth_num.put(clothes[a][1],num);
            
        }
        cloth_type_array = cloth_num.keySet().toArray(new String[0]);//0을 넣으면 자동으로 배열의 길이가 결정됨.
        
        for(int b = 0 ; b < cloth_type_array.length; b++){
            answer = answer * cloth_num.get(cloth_type_array[b]);
        }
        
        return answer-1; //아예 안입는 조건은 제외
    }
}
