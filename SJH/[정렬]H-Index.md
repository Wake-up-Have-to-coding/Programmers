- 문제 링크 : [프로그래머스-H-Index](https://school.programmers.co.kr/learn/courses/30/lessons/42747)<br>
- 목적 : 논문 n편 중, h번 이상 인용된 논문의 수가 h편 이상일 때, h가 가질 수 있는 최대값을 찾는다.<br>
  즉, h의 최대값 => 인용된 논문의 개수(책의 수) == 논문이 이용된 개수(책을 빌린 횟수)<br>
- 인용된 논문을 담은 배열을 내림차순으로 변경한 후, 값을 하나씩 비교하여 인용된 논문과 논문을 이용한 횟수를 구한다.<br>
  따라서, 아무리 인용된 횟수가 많아도 논문의 개수가 적다면 논문의 개수가 h의 최대값이 된다. 

~~~
<고려해야 할 것>
1. h번 이상 인용된 논문이 있는 경우, h번 이상 인용된 논문의 수가 적을 때,
  ex_) [22,32] 결과 : 2 -> 인용된 논문의 수가 결과가 됨
  
2. 논문의 수가 많을 경우, h번 이상 인용된 논문이 적을 때,
  ex_) [1,2,4,3,2,2,5,4] 결과 => [1,2,2,2,3,4,4,5]
~~~

### :pushpin: 1차 코드 (성공)

```java
import java.util.*;

class Solution {
 public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=citations.length-i){ 
                if(i==0){ 
                     answer = citations.length;
                     break;
                }
                else{
                    answer = citations.length-i;
                    break;
                }
            }
        }
        return answer;
    }
}
```

### :pushpin: 2차 코드 (성공)

```java
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int index = 0;
        int[] citations_convert = new int[citations.length];
        Arrays.sort(citations);
         for(int i=0; i<citations.length; i++){ 
             citations_convert[i] = citations[citations.length - (i+1)];
         }

        if(citations_convert[0] ==0) return answer;
        for(index = 0; index<citations_convert.length; index++){
            if(citations_convert[index]>=index+1){ //6>1 5>2 3>=3 1>4 
                answer = index+1;
            }
        }

        if(answer==0)
            answer = index;
        return answer;
    }
}
```
