
import java.util.*;
import java.util.stream.Collectors;

public class Test22 {

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> res = new ArrayList<>();

        List<String> OrderGenreForPlayCount = new ArrayList<>();  // 1.플레이 횟수가 많은 순서대로 장르를 정렬

        //1.1 : 해쉬맵에 <장르, 총플레이횟수> 로 저장
        HashMap<String,Integer> genreWithTotalPlayCounts = new HashMap<>();
        Set<String> genre = Arrays.stream(genres).collect(Collectors.toSet());
        for(int i = 0; i < genres.length; i++) {
            genreWithTotalPlayCounts.put(genres[i], genreWithTotalPlayCounts.getOrDefault(genres[i],0)+plays[i]);
        }
        //1.2 : 총 플레이횟수를 기준으로 정렬을 해서 OrderGenreForPlayCount에 넣자.
        List<Integer> list = new ArrayList<>(genreWithTotalPlayCounts.values());
        Collections.sort(list);

        // 1번 완성 -> 플레이 횟수가 많은 순서대로 장르를 정렬.
        for(int i = list.size()-1; i>=0; i--) {
            for (String s : genreWithTotalPlayCounts.keySet()) {
                if(Objects.equals(list.get(i), genreWithTotalPlayCounts.get(s))) {
                    OrderGenreForPlayCount.add(s);
                }
            }
        }

        //2. 해쉬 맵<인덱스, 반복횟수>
        HashMap<Integer,Integer> genreWithPlays = new HashMap<>();
        for(int i = 0; i<plays.length; i++) {
            genreWithPlays.put(i,plays[i]);
        }

        //3. 반복 횟수를 오름차순으로 정렬
        Arrays.sort(plays);

        int count;

        for(int i = 0; i<OrderGenreForPlayCount.size(); i++) {  // 플레이 횟수가 많은 것부터 검색.
            count = 0;
            for(int j = plays.length-1; j>=0; j--) {  // 플레이 횟수 많은 것부터 내림차순으로 장르 검색
                for (Integer key : genreWithPlays.keySet()) {
                    if (genreWithPlays.get(key) == plays[j] && OrderGenreForPlayCount.get(i).equals(genres[key])) {
                        res.add(key);
                        count++;
                        if(count == 2) {  // 장르당 2개의 곡만 결과 리스트에 추가.
                            break;
                        }
                    }
                }
                if(count==2) {
                    break;
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int[] result;
        String[] genres= {"classic","pop","classic","classic","pop"};
        int[] plays = {500,600,150,800,2500};

        result = solution(genres,plays);
        System.out.println(Arrays.toString(result));
    }
}
