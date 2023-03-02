- 문제 링크 : [프로그래머스-최소 직사각형](https://school.programmers.co.kr/learn/courses/30/lessons/86491)<br>
- 목적 : 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들기.<br>
  -> 모든 명함의 가로, 세로 길이를 조사하여 그 중에서 모든 명함을 수납할 수 있는 가장 작은 명함을 만들어야 한다.
- 배열로 들어오는 명함들은 모두 가로와 세로가 있게 들어오지만, 지갑에 넣을 때는 가로 -> 세로, 세로 -> 가로로 혼용될 수 있다는 점을 이용한다.<br>

~~~
<고려해야 할 것>
1. 딱히 없음.
~~~

### :pushpin: 1차 코드 (성공)

```java
import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        //가로와 세로 중 긴 부분과 짧은 부분을 각각 같은 열에 둔다.
        int answer = 0;
        int w_max = 0;
        int h_max = 0;
        //System.out.println(sizes.length);
        for(int i = 0 ; i < sizes.length ; i++){
            //나는 앞에 긴 값을 둔다.
            //앞이 w , 뒤가 h
            if(sizes[i][0]<sizes[i][1]){ //50,60 -> 60,50
                if(sizes[i][1]>w_max){
                    w_max = sizes[i][1];
                }
                if(sizes[i][0]>h_max){
                    h_max = sizes[i][0];
                }
            }else{
                if(sizes[i][1]>h_max){
                    h_max = sizes[i][1];
                }
                if(sizes[i][0]>w_max){
                    w_max = sizes[i][0];
                }
            }
        }
        answer = h_max * w_max;
        return answer;
    }
}
```
