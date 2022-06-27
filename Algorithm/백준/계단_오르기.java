/**
 *  [규칙 ]
 * 	1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
 * 	   즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 * 	2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 *  3. 마지막 도착 계단은 반드시 밟아야 한다.
 */
public class 계단_오르기 {

    public static void main (String[] args) {
        int[] steps = {10, 20, 15, 25, 10, 20};

        totalBiggestStep(steps);
    }

    public static int totalBiggestStep (int[] steps) {
        int answer = 0;

        int[] dp = new int[steps.length + 1];

        dp[1] = steps[1];
        // 계단이 한칸 혹은 두칸으로 이루어졌을경우
        if (steps.length >= 2) {
            dp[2] = steps[1] + steps[2];
            // 계단은 많이 밟을수록 값이 높아지고
            // 마지막 도착 계단은 반드시 밟아야 함.
        }

        // 계단이 세개 이상일때 부터 반복
        for (int i = 3; i < steps.length + 1; i++) {
            /**
             *  현재 차례의 계단을 밟는 다는 가정 하에
             *  바로 이전의 계단을 밟을지 or 전전의 계단을 밟을지
             *  더 큰 값을 선택하고 현재 계단 값을 더해줌.
             */
            dp[i]  = Math.max(dp[i-2], dp[i-3] + steps[i-1]) + steps[i];
        }

        return answer;
    }
}
