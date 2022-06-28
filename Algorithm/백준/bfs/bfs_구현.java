import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  사용 필드
 *  boolean[] visited
 *  Queue<Integer> que
 *  int[][] lines
 */
public class bfs_구현 {

    static int[][] lines;
    static boolean[] visited;
    static Queue<Integer> que;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int lineCount = sc.nextInt();
        int start = sc.nextInt();

        lines = new int[node+1][node+1];
        visited = new boolean[node + 1];

        for (int i = 0; i < lineCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            lines[a][b] = lines[b][a] = 1;
        }

        que = new LinkedList<>();
        que.add(start);

        String answer = "";
        visited[start] = true;

        while (!que.isEmpty()) {
            int temp = que.poll();

            for (int i = 1; i <= node; i++) {
                //queue 안에 인접 리스트 넣기
                if (!visited[i] && lines[temp][i] == 1) {
                    visited[i] = true;
                    que.add(i);
                }
            }

            answer += temp + " ";
        }

        System.out.println(answer);
    }
}
