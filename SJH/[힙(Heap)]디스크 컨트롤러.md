### :pushpin: 1차 코드 (실패)

```java
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        //job[작업 요청 시점][작업의 소요시간]
        int answer = 0;
        int time = -1; // 총 시간
        int working_time = -1; //일을 수행할 때 수행하나 시간
        int count = 0; //수행된 작업의 수
        int request_index = -1; //디스크가 수행하는 인덱스
        int request_disc = 0; //수행전 대기 하는 놈
        int request_time = 0; //요청 들어간 시간
        int working_disc = -1; //하드디스크가 수행하고 있는 요청
        
        while(count<jobs.length){
            time++;// 시간은 간다.
            for(int i = 0 ; i < jobs.length ; i++){
                //디스크가 요청 받지 않고 time이 요청 들어온 시간 보다 높은 경우
                if(time >= jobs[i][0] && working_disc == -1 && jobs[i][0] != -1){
                    if(request_disc > jobs[i][1]){ //대기된거보다 짧으면
                        request_disc = jobs[i][1];
                        request_index = i;
                        request_time = jobs[i][0];
                    }else if(request_disc == jobs[i][1]){//대기랑 같으면
                        if(request_time > jobs[i][0]){
                            request_disc = jobs[i][1];
                            request_index = i;
                            request_time = jobs[i][0];
                        }
                    }
                    if(i == jobs.length-1 && working_disc == -1){
                        working_disc = request_disc;
                        jobs[i][0] = -1;
                        break;
                    }
                }
            }
            if(working_disc != -1){
                working_time++;
                if(working_time == working_disc){
                    working_disc = -1;
                    count++;
                    answer += (time - request_time);
                }
            }
            
        }
        
        return answer/jobs.length;
       
    }
}
```

<br>

### :pushpin: 2차 코드 (실패)

```java
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        //job[작업 요청 시점][작업의 소요시간]
        int answer = 0;
        int time = -1;
        int working_time = -1;
        int count = 0;
        //끝낸시간 내놔라 다 더 하면 되니까 굳이 배열 쓰지마~
        int worked_time = 0;
        time_Disc check_request;
        Disc check_work;
        Disc working_disc = null;
        PriorityQueue<time_Disc> sorting_disc = new PriorityQueue<time_Disc>();
        PriorityQueue<Disc> request_disc = new PriorityQueue<Disc>();
        
        
        for(int i = 0; i < jobs.length; i++){
            sorting_disc.offer(new time_Disc(jobs[i][0],jobs[i][1]));
        }
        
        while(count < jobs.length){
            time++; //시간은 가지
            while(!sorting_disc.isEmpty()){
                check_request = sorting_disc.peek();
                if(check_request.request_time == time){
                    check_request = sorting_disc.poll();
                    request_disc.offer(new Disc(check_request.request_time,check_request.working_time));
                }
            }
            check_work = request_disc.peek();
            if(working_disc == null && check_work.request_time == time){
                working_disc = request_disc.poll();
            }else if(working_disc.working_time == working_time){
                working_disc = null;
                answer += (time - working_disc.request_time);
                count++;
            }
            
            if(working_disc != null){
                working_time++;
            }
            
            
        }
        answer = worked_time / jobs.length;
        
        return answer;
    }
    
    class Disc implements Comparable<Disc> {
        int request_time;
        int working_time;

        public Disc(int request_time, int working_time) {
            this.request_time = request_time;
            this.working_time = working_time;
        }

        @Override
        public int compareTo(Disc disc) {
            return this.working_time <= disc.working_time ? -1 : 1;
        }   
    }
    class time_Disc implements Comparable<time_Disc> {
        int request_time;
        int working_time;

        public time_Disc(int request_time, int working_time) {
            this.request_time = request_time;
            this.working_time = working_time;
        }

        @Override
        public int compareTo(time_Disc disc) {
            return this.request_time <= disc.request_time ? -1 : 1;
        }   
    }

}
```

<br>

### :pushpin: 3차 코드 (성공)

```java
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        //job[작업 요청 시점][작업의 소요시간]
        //끝낸시간 내놔라 다 더 하면 되니까 굳이 배열 쓰지마~
        int sum_working_time = 0;
        int time = -1;
        int working_time = -1;
        int count = 0;
        int count1 = 0;
        Disc working_disc = null;
        PriorityQueue<Disc> disc_controller = new PriorityQueue<Disc>();

        while (count < jobs.length) {
            time++; //시간은 가지
            if (count1 < jobs.length) {
                //요청 받기 전에 확인하기
                if (working_disc == null && !disc_controller.isEmpty()) {
                    working_disc = disc_controller.poll();
                    working_time++;
                }
                for (int i = 0; i < jobs.length; i++) {
                    //디스크 컨트롤러가 요청 받는다.
                    if (time == jobs[i][0]) {
                        disc_controller.offer(new Disc(jobs[i][0], jobs[i][1]));
                        count1++;
                    }
                }
            }
            if (working_disc == null && !disc_controller.isEmpty()) {
                working_disc = disc_controller.poll();
                working_time++;
            }else if(working_disc != null){
                working_time++;
                if (working_time == working_disc.working_time) {
                    // System.out.println("대기시간 : " + check_finish.wait_start_time);
                    // System.out.println("소요시간 : " +check_finish.working_time);
                    // System.out.println("시간 : " + time);
                    // System.out.println("일한 시간 : " +working_time);
                    sum_working_time += (time - working_disc.wait_start_time);
                    working_disc = null;
                    working_time = -1;
                    if(!disc_controller.isEmpty()) {
                        working_disc = disc_controller.poll();
                        working_time++;
                    }
                    count++;
                }
            }
        }

        return sum_working_time / jobs.length;
    }


    class Disc implements Comparable<Disc> {
        int wait_start_time;
        int working_time;

        public Disc(int wait_start_time, int working_time) {
            this.wait_start_time = wait_start_time;
            this.working_time = working_time;
        }

        @Override
        public int compareTo(Disc disc) {
            return this.working_time < disc.working_time ? -1 : 1;
        }
    }
}

```
