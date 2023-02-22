class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int max = 0;
        int min = 0;
        
        // 배열 중 최대, 최소값
        for(int i=0; i<citations.length; i++)
        {
            if(citations[i] > max)
                max = citations[i];
        }
        
        // n편 안에 답이 있음(성능 향상)
        if(max > citations.length)
            max = citations.length;
        
        for(int i= min; i<=max; i++){ //min ~ max까지
            int quotation = 0; //논문 수
            for(int j=0; j<citations.length; j++){
                if(citations[j] >= i) //i번 이상 인용된 논문 개수
                    quotation++;
            }    
            if(quotation >= i) //i번 이상 인용된 논문이 i편 이상일 경우
                answer = i;
        }

        return answer;
    }
}