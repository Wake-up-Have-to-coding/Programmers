import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        List<Song> songs = new ArrayList<>();
        Map<String, Integer> totalPlays = new HashMap<>(); //장르별 총 재생횟수
        
        //setting
        for(int i=0; i<genres.length; i++){
            int play = plays[i];
            Song song = new Song(i, genres[i], play);
            songs.add(song);//genres,plays 합치는 작업
            
            totalPlays.compute(genres[i], (k,v)-> (v== null) ? play : v + play);
        }
        
        Collections.sort(songs, new totalPlaysComparator(totalPlays));
        
        String genre = null;
        int count = 0;
        
        //두 개 뽑기
        for(Song song : songs){
            //이미 나온 장르
            if(song.genre.equals(genre)){
                if(count == 1){
                    answer.add(song.index);
                    count++;
                }
            }else{ // 새로 등장한 장르
                count = 0;
                answer.add(song.index);
                genre = song.genre;
                count++;
            } 
        }
        return answer;
    }
    
    class Song{
        int index;
        String genre;
        int play;
        
        public Song(int index, String genre, int play){
            this.index = index;
            this.genre = genre;
            this.play = play;
        }
    }
    
    class totalPlaysComparator implements Comparator<Song>{
        Map<String, Integer> totalPlays = null;
        
        public totalPlaysComparator(Map<String, Integer> totalPlays){
            this.totalPlays = totalPlays;
        }
        
        @Override
        public int compare(Song s1, Song s2) {
            //같은 장르 -> 재생 수로 정렬
            if(s1.genre.equals(s2.genre)){
                if(s1.play > s2.play) //재생 횟수로 비교
                    return -1; // 위치 그대로 유지
                else
                    return 1; // 두 비교 대상 위치 변경
            }else{ //다른 장르 -> totalPlays 장르 순위로 정렬(내림차순)
                return totalPlays.get(s2.genre).compareTo(totalPlays.get(s1.genre));
            }   
        } 
        // 장르 -> 재생횟수 -> 고유번호 
    }
}