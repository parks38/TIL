import java.util.*;

/**
 *  상하좌우 1 으로 생성 그다음 ++
 *  int[][] box
 *  boolean[][] visited
 *
 *  정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
 가장 빠르게 번지는 방법 확님ㄴ 
 */
public class 토마토 {

    static boolean[][] visited;
    static Queue<Position> start;
    static int[][] box;
    static int[] xUpdate = {-1, 0, 1, 0};
    static int[] yUpdate = {0, 1, 0, -1};
    static int row;
    static int col;
    static int count;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();

        visited = new boolean[col][row];
        box = new int[col][row];
        start = new LinkedList<>();

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                int x = sc.nextInt();
                box[i][j] = x;
                if (x == 1) {
                    start.add(new Position(i, j)); // starting position 모두 QUEUE ADD
                } else if (x == -1) {
                    visited[i][j] = true;
                }
            }
        }
        count = 0;
        bfs();
        System.out.println(count);
    }

    public static void bfs() {

        // 하나의 day 안에 처리할 position 들의 모음.
        Queue<Position> newQue = new LinkedList<>();

        while (!start.isEmpty()) {

            Position temp = start.poll();

            for (int i = 0; i < 4; i++) {
                int xtemp = temp.x + xUpdate[i];
                int ytemp = temp.y + yUpdate[i];

                if (xtemp >= 0 && ytemp >= 0 && xtemp < col && ytemp < row) { // 범위 안에 존재하기
                    if (box[xtemp][ytemp] == 0 && !visited[xtemp][ytemp]) {
                        visited[xtemp][ytemp] = true;
                        newQue.add(new Position(xtemp, ytemp));
                    }
                }
            }
            // 당일에 해당하는 position 모두 업데이트 됐다면
            // count++ 으로 day update 해주고
            // 다음 탐색해야하는 위치 return
            if (start.isEmpty() && !newQue.isEmpty()) {
                count++;
                start.addAll(newQue);
                newQue.clear();
            }
        }

    }
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x =x;
        this.y=y;
    }
}
