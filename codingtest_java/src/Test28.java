import java.util.*;

public class Test28 {

    public static class Node {
        int data;
        boolean visited;
        Node rNode;
        Node lNode;

        public Node(int data) {
            this.data = data;
            this.visited=false;
            rNode= null;
            lNode= null;
        }
    }

    public static Node makeNode(int data) {
        return new Node(data);
    }


    public static void makeTree(Node node, Map<Integer,List<Integer>> vertexAndEdge) {
        int nodeData = node.data;

        List<Integer> data = vertexAndEdge.get(nodeData);
        if (data.isEmpty()) {
            return;
        }else if(data.size() == 2) {
            node.lNode = makeNode(data.getFirst());
            makeTree(node.lNode, vertexAndEdge);
            node.rNode = makeNode(data.getLast());
            makeTree(node.rNode, vertexAndEdge);
        }else {
            node.lNode = makeNode(data.getFirst());
            makeTree(node.lNode, vertexAndEdge);
        }
    }

    public static void inOrderTravers(Node node,int[] info) {
        if(node.lNode != null) {
            inOrderTravers(node.lNode, info);
        }

        if(node.lNode == null && node.rNode==null && info[node.data] == 1) {
            node.visited= true;
        }

        //System.out.print(node.data + " ");

        if(node.rNode != null) {
            inOrderTravers(node.rNode, info);
        }

    }

    public static boolean judgeNode(Node node, int[] info) {
        if(node.lNode == null && node.rNode == null) {
            return false;
        }else if(node.rNode == null && info[node.lNode.data] == 1) {
            node.lNode.visited=true;
            return false;
        }else if(info[node.rNode.data] == 1 && info[node.lNode.data] == 1) {
            node.rNode.visited=true;
            node.lNode.visited=true;
            return false;
        }
        return true;
    }


    public static int solution(int[] info, int[][] edges) {
        
        Map<Integer, List<Integer>> vertexAndEdge = new HashMap<>();
        for(int i = 0 ; i < info.length; i++) {
            vertexAndEdge.put(i,new ArrayList<>());
            for(int j = 0; j < edges.length; j++) {
                if(edges[j][0] == i) {
                    List<Integer> list = vertexAndEdge.get(i);
                    list.add(edges[j][1]);
                    vertexAndEdge.put(i,list);
                }
            }
        }
  //      System.out.println("vertexAndEdge = " + vertexAndEdge);

        // Tree의 rootNode 생성
        Node rootNode = makeNode(0);

        // edge를 활용해서 트리 만들기
        makeTree(rootNode, vertexAndEdge);
/*

        // 양이 위치한 인덱스만 리스트로 빼기
        List<Integer> sheepVertex = new ArrayList<>();
        for(int i =0 ; i<info.length; i++) {
            if(info[i] == SHEEP) {
                sheepVertex.add(i);
            }
        }


        // 양이 위치한 인덱스 확인
        System.out.println("sheepVertex = " + sheepVertex);


 */
        int numOfSheep = 0;
        int numOfWolf = 0;
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(rootNode);
        rootNode.visited =true;
        numOfSheep++;

        // 순회를 통해서 리프(트리의끝단)인데 늑대인 경우는 방문 표시를 해서 검색하지 않도록 한다.
        inOrderTravers(rootNode,info);

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i<queueSize; i++) {
                Node node = queue.poll();

                if (node.lNode != null && !node.lNode.visited) {
                    if (info[node.lNode.data] == 1) {
                        numOfWolf++;
                    } else {
                        numOfSheep++;
                    }
                    queue.offer(node.lNode);
                    node.lNode.visited = true;
                }

                if (node.rNode != null && !node.rNode.visited) {
                    if (info[node.rNode.data] == 1) {
                        numOfWolf++;
                    } else {
                        numOfSheep++;
                    }
                    queue.offer(node.rNode);
                    node.rNode.visited = true;
                }
            }
            if(numOfWolf >= numOfSheep) break;
        }

        return numOfSheep;
    }

    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        int result;
        result = solution(info,edges);
        System.out.println("result = " + result);


    }
}
