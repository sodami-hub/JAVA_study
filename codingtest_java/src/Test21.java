import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test21 {

    public static String[] solution(String[] record) {
        String cmd ="";
        String uid= "";
        String nick= "";

        List<Integer> list;

        HashMap<String,String> uidAndNickMap = new HashMap<>();  // HashMap<uid, nick>
        HashMap<String,List<Integer>> uidAndStrMap = new HashMap<>(); //HashMap<uid, 출력문 index>

        List<String> res = new ArrayList<>();

        int cmdIndex = 0;
        String cmdStr;

        for (String s : record) {
            String[] array = s.split(" ");
            cmd = array[0];
            uid = array[1];
            if(!cmd.equals("Leave")) nick = array[2];

            switch (cmd) {
                case "Enter" :
                    if(!uidAndNickMap.containsKey(uid)) {
                        uidAndNickMap.put(uid,nick);

                        cmdStr = nick+"님이 들어왔습니다.";
                        res.add(cmdStr);

                        list = new ArrayList<>();
                        list.add(cmdIndex++);
                        uidAndStrMap.put(uid,list);
                    } else if(uidAndNickMap.get(uid).equals(nick)) {
                        cmdStr = nick+"님이 들어왔습니다.";
                        res.add(cmdStr);
                        list = uidAndStrMap.get(uid);
                        list.add(cmdIndex++);
                        uidAndStrMap.put(uid,list);
                    } else{
                        String oldNick = uidAndNickMap.get(uid);
                        list = uidAndStrMap.get(uid);
                        for (Integer i : list) {
                            String change = res.get(i).replace(oldNick,nick);
                            res.remove((int)i);
                            res.add(i,change);
                        }
                        cmdStr= nick+"님이 들어왔습니다.";
                        res.add(cmdStr);
                        uidAndNickMap.put(uid,nick);
                        list.add(cmdIndex++);
                        uidAndStrMap.put(uid,list);
                    }
                    break;
                case "Leave":
                    nick = uidAndNickMap.get(uid);
                    cmdStr = nick+"님이 나갔습니다.";
                    res.add(cmdStr);
                    list = uidAndStrMap.get(uid);
                    list.add(cmdIndex++);
                    uidAndStrMap.put(uid,list);
                    break;
                case "Change" :
                    String oldNick = uidAndNickMap.get(uid);
                    list = uidAndStrMap.get(uid);
                    for (Integer i : list) {
                        String change = res.get(i).replace(oldNick,nick);
                        res.remove((int)i);
                        res.add(i,change);
                    }
                    uidAndNickMap.put(uid,nick);
                    break;
            }
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] result;
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
                           "Enter uid1234 Prodo","Change uid4567 Ryan"};
        result = solution(record);
        System.out.println(Arrays.toString(result));
    }
}
