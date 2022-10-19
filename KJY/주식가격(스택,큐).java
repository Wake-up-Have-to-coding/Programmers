class Solution {
    public int[] solution(int[] prices) {
        int count = prices.length;    
        int[] answer = new int[count];
        int stock = 0; //주식
        int time = 0;
        for(int i=0; i<count; i++){
            stock = prices[i];
            for(int j=i+1; j<count; j++){
                time++; //시간은 흐른다~
                if(stock > prices[j]){
                    break;
                }
            }
            
            answer[i] = time;
            time = 0;
        }
        return answer;
    }
}