import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BFS
 * - 상하좌우 => if (path[i][j] ==1 && !visited[i][j]
 * - 상하좌우 움직이고 끝날때 ++;
 *
 * boolean[][] visited
 * Queue<Integer> que
 * int[][] path
 * int answer
 */
public class 단지 {

    static int[][] path;
    static boolean[][] visited;
    static Queue<Location> que;
    static int line;
    static int[] xUpdate = {-1, 0, 1, 0};
    static int[] yUpdate = {0,1,0,-1};

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        line = sc.nextInt();
        path = new int[line][line];
        // 길 생성
        for(int i = 0; i < line; i++) {
            String lines = sc.next();
            for(int j = 0; j < line; j++) {
                path[i][j] = Character.getNumericValue(lines.charAt(j));
            }
        }

        visited = new boolean[line][line];
        que = new LinkedList<>();
        int danji = 0;

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line; j++) {
                if (path[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j);
                    danji++;
                    //System.out.println("IIII: " + i + " " + j + " " + danji);
                }
            }
        }

        System.out.println(danji);
    }

    public static void bfs (int i, int j) {
        que.add(new Location(i, j));

        while (!que.isEmpty()) {
            Location temp = que.poll();

            for (int z = 0; z < 4; z++) {
                int xs = temp.x + xUpdate[z];
                int ys = temp.y + yUpdate[z];

                if (xs >= 0 && ys >= 0 && xs < line && ys < line) {
                    if (path[xs][ys] == 1 && !visited[xs][ys]) {
                        visited[xs][ys] = true;
                        que.add(new Location(xs, ys));
                    }
                }
            }
        }
    }
}

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x= x;
        this.y = y;
    }
}
