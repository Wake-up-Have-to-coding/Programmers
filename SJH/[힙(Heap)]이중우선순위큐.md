### :pushpin: 1차 코드 (성공)

//목적 :  큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]<br>
//최대값, 최소값 삭제시 2개 이상씩 있으면 '하나만 삭제'<br>
//빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시<br>

```java
import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];//2[0,0]
        ArrayList<Integer> operation_queue = new ArrayList<Integer>();
        int input_data = 0; //넣을값
        int max_min = 0; //max거나 min이거나
        for(String command : operations){
            //I 숫자 = 숫자 삽입
            if(command.contains("I")){
                input_data  = Integer.parseInt(command.substring(2, command.length())) ;
                operation_queue.add(input_data);
            }//D 1 큐에서 최대값 삭제
            else if(command.equals("D 1")){
                if(!operation_queue.isEmpty()){
                    max_min = Collections.max(operation_queue);
                    operation_queue.remove(operation_queue.indexOf(max_min));
                }
                //operation_queue.remove(inde)
            }//D -1 큐에서 최솟값 삭제
            else{
                if(!operation_queue.isEmpty()){
                    max_min = Collections.min(operation_queue);
                    operation_queue.remove(operation_queue.indexOf(max_min));
                }
            }
            //System.out.println(operation_queue.toString());
        }
        if(!operation_queue.isEmpty()){
            if(operation_queue.size() > 1){
                answer[0] = Collections.max(operation_queue);
                answer[1] = Collections.min(operation_queue);
            }else{
                answer[0] = Collections.max(operation_queue);
                answer[1] = 0;
            }
        }
        return answer;
    }
}
```
