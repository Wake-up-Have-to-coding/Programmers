### :pushpin: 1차 코드 (성공)

//목적 :  array에 잇는 숫자를 commands의 commands[i][1]부터 commands[i][1]까지 자른다. 정렬 이후 commands[i][2]번째 확인<br>
//반복문을 통해 새로운 list에 add한 후 정렬해서 해당 위치에 맞는 값을 찾는다.<br>

```java
import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<Integer>();  
        ArrayList<Integer> sortList = new ArrayList<Integer>(); 
        for(int i = 0; i < commands.length; i++){
            for(int k = commands[i][0]-1; k < commands[i][1]; k++){
                sortList.add(array[k]);
            }
            sortList.sort(Comparator.naturalOrder());
            //System.out.println(sortList.toString());
            answer.add(sortList.get(commands[i][2]-1));
            sortList.clear();
        }
        return answer;
    }
}
```
