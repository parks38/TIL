import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        List<Integer> winList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
     
        int count = 0;
        int zero = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            
            if (lottos[i] == 0) zero++;
            if (winList.contains(lottos[i])) count++;
        }

        answer[0] = Math.min(6 - (count+zero) + 1, 6);
        answer[1] = Math.min(6 - (count) + 1, 6);
        return answer;
    }
}
