import java.util.*;
/**
    메모리: 318356 KB 시간 : 1548 ms
 */

class Main {

    static boolean[] visited;
    static int[][] nodePath;
    static int nodes, lines;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // lines, nodes
        nodes = sc.nextInt();
        lines = sc.nextInt();

        int answer = 0;

        visited = new boolean[nodes+1]; // 1부터 
        nodePath = new int[nodes+1][nodes+1];

        for (int i = 0; i < lines; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            nodePath[node1][node2] = nodePath[node2][node1] = 1;
        }
        /**
            노드가 더 이상 연결되어 있지 않은 경우 
         */
        for(int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;   // 연결 노드의 개수 
            }
        }

        System.out.println(answer);
    }

    public static void dfs (int nodeA) {
        if (visited[nodeA]) return; // dfs안의 method 에서 부를때를 위해 체크 

        visited[nodeA] = true;

        for (int i = 1; i <= nodes; i++) {
            if (nodePath[nodeA][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
