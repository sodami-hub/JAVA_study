import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test23 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        // 이용이 정지된 id 리스트
        List<String> stopList = new ArrayList<>();

        // 결과를 저장할 리스트
        List<Integer> result = new ArrayList<>();


        List<String> strList;
        // 해당 id가 신고한 id
        HashMap<String, List<String>> idForReported = new HashMap<>();
        for (String s : id_list) {
            strList = new ArrayList<>();
            idForReported.put(s,strList);
        }

        // 해당 id가 신고당한 횟수
        HashMap<String, Integer> idForReportCount = new HashMap<>();

        String[] reportArray;
        for (String s : report) {
            reportArray = s.split(" ");

            strList = idForReported.get(reportArray[0]);
            if(!strList.contains(reportArray[1])){
                strList.add(reportArray[1]);
                idForReported.put(reportArray[0],strList);
            } else {
                continue;  // 이미 같은 id를 신고했으면 아래 신고 당한 횟수를 추가하지 않음.
            }

            idForReportCount.put(reportArray[1], idForReportCount.getOrDefault(reportArray[1], 0)+1);

        }

        for (String s : idForReportCount.keySet()) {
            if(idForReportCount.get(s) >= k) {
                stopList.add(s);
            }
        }
        int resultCount;
        for (int i = 0; i < id_list.length; i++) {
            resultCount=0;
            strList = idForReported.get(id_list[i]);

            for(int j = 0; j < stopList.size(); j++) {
                for (String s : strList) {
                    if(s.equals(stopList.get(j))) {
                        resultCount++;
                    }
                }
            }
            result.add(resultCount);
        }


        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int k;
        int[] result;
        
        String[] id_list = {"muzi","frodo","apeach","neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        k = 2;
        result = solution(id_list,report,k);
        System.out.println(Arrays.toString(result));

        String[] id_list01 = {"con","ryan"};
        String[] report01 = {"ryan con","ryan con","ryan con","ryan con"};
        k= 3;
        result = solution(id_list01,report01,k);
        System.out.println(Arrays.toString(result));

    }
}
