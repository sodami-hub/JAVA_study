import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test25 {

    private static String res = "";

    public static String preOrder(int[] nodes, int idx) {
        res += String.valueOf(nodes[idx]);

        if(idx*2 < nodes.length) {
            preOrder(nodes,idx*2);
        }

        if(idx*2+1 < nodes.length) {
            preOrder(nodes, idx*2+1);
        }

        return res;
    }

    public static String inOrder(int[] nodes, int idx) {
        if(idx*2 < nodes.length) {
            inOrder(nodes,idx*2);
        }
        res += String.valueOf(nodes[idx]);

        if(idx*2+1 < nodes.length) {
            inOrder(nodes, idx*2+1);
        }

        return res;
    }

    public static String postOrder(int[] nodes, int idx) {
        if(idx*2 < nodes.length) {
            postOrder(nodes,idx*2);
        }

        if(idx*2+1 < nodes.length) {
            postOrder(nodes, idx*2+1);
        }

        res += String.valueOf(nodes[idx]);


        return res;
    }


    public static String[] solution(int[] nodes) {
        List<String> result = new ArrayList<>();

        int[] newNodes = new int[nodes.length+1];

        for(int i = 0; i< newNodes.length; i++) {
            if(i==0) {
                newNodes[i] = 0;
                continue;
            }
            newNodes[i] = nodes[i-1];
        }

        res = "";
        res = preOrder(newNodes, 1);
        result.add(res);

        res = "";
        res = inOrder(newNodes, 1);
        result.add(res);

        res = "";
        res = postOrder(newNodes, 1);
        result.add(res);

        return result.toArray(new String[0]);
    }


    public static void main(String[] args) {
        String[] result;
        int[] nodes = {1,2,3,4,5,6,7};
        result = solution(nodes);
        System.out.println(Arrays.toString(result));
    }
}
