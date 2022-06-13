## K번째 수

### | 풀이 방법

> Arrays.copyOfRange(원본배열, 복사할 인덱스, 복사할 끝인덱스);

- 원본 배열은 복사된 것이므로 변경 되지 않습니다.
- index는 0 부터 시작하는 것이 default
- 마지막 index 는 (index - 1) 까지 복사
- 기타 : Arrays.copyOf(원본배열, 복사할 길이);

### | 풀이 (자바)

```
import java.util.Arrays;

public class K번째수 {

  public static void main (String args[]) {
    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    System.out.println(Arrays.toString(solution(array, commands)));
  }

  public static int[] solution (int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for (int i = 0; i < commands.length; i++) {
      int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);

      Arrays.sort(temp);

      answer[i] = temp[commands[i][2]-1];
    }

    return answer;
  }
}
```
