import java.util.*;
/**
*  키패드 누르기 공식 존재 
*  08/06/2022
*/
class 키패드_누르기 {
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftPosition = 0;
        int rightPosition = 0;
        for (int i = 0; i < numbers.length; i++) {
            int curr = numbers[i];
            
            // anyMatch, contains 
            if (curr % 3 == 1) {
                answer += "L";
                leftPosition = curr;
            } else if (curr % 3 == 0 && curr != 0){
                answer += "R";
                rightPosition = curr;
            } else {  // 2,5,8,0
                if (curr == 0) curr = 11; 
                /** 
                    [-1, +1, -3, +3] (같은 차이) 
                 */

                int gapRight = Math.abs(curr - rightPosition) / 3 + Math.abs(curr - rightPosition) % 3;
                int gapLeft = Math.abs(curr - leftPosition) / 3 + Math.abs(curr - leftPosition) % 3;

                if (gapRight - gapLeft > 0) {
                    answer += "L";
                    leftPosition = curr;
                } else if (gapRight - gapLeft < 0) {
                    answer += "R";
                    rightPosition = curr;
                } else { // gap == 0
                /**
                * Gap 차이가 달라도 위 아래 양옆은 1 차이가 남으로 
                 */
                    if (hand == "right") {
                        answer += "R";
                        rightPosition = curr;
                    } else {
                        answer += "L";
                        leftPosition = curr;
                    }
                }
            }
        }
        return answer;
    }
}

/**
    공식 :  Math.abs(curr - rightPosition) / 3 + Math.abs(curr - rightPosition) % 3;
    - Math.abs(curr - rightPosition) / 3 : 위아래 체크 (차이가 3)
    - Math.abs(curr - rightPosition) % 3 : 양옆 1 차이 확인 

    1   2   3
    4   5   6
    7   8   9 
    10  11  12 

    | curr | right | 차이(위아래 + 양옆)|
    | -----|-------|---------------|
    |  2   |   1   | 0 + 1 = 1  |
    |  2   |   3   | 0 + 1 = 1  |
    |  2   |   5   | 1 + 0 = 1  |
    |  5   |   2   | 1 + 0 = 1  |
    |  5   |   4   | 0 + 1 = 1  |
    |  5   |   6   | 0 + 1 = 1  |
    |  5   |   8   | 1 + 0 = 1  |
    |  8   |   7   | 0 + 1 = 1  |
    |  8   |   9   | 0 + 1 = 1  |
    |  8   |   5   | 1 + 0 = 1  |
    |  8   |   11  | 1 + 0 = 1  |

 */
