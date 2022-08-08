import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class FailStages {

    public static void main (String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        System.out.println(Arrays.toString(solution(5, stages)));
    }

    public static int[] solution (int n, int[] stages) {

        Map<Integer, Double> map = new HashMap<>();
        int[] stageCount = new int[n+1];
        Arrays.sort(stages);

        for(int stage : stages) if (stage <= n) stageCount[stage]++;

        int total = stages.length; // total count people
        for (int i = 1; i < stageCount.length; i++) {
            total = total - stageCount[i-1];
            map.put(i, (double) stageCount[i] / (total));
        }

        LinkedList<Map.Entry<Integer, Double>> mapList = new LinkedList<>(map.entrySet());
        Collections.sort(mapList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        int[] answer = new int[n];
        int count = 0;
        for (Map.Entry<Integer, Double> m : mapList) {
            answer[count] = m.getKey();
            count++;

        }
        return answer;
    }

//    public static int[] solution (int n, int[] stages) {
//
//        List<Integer> answer = new LinkedList<>();
//
//        Map<Integer, Double> map = new HashMap<>();
//        int total = stages.length;  // count of percentage total
//
//        Arrays.sort(stages);
//
//        for (int i = 1; i <= n; i++) {
//            map.put(i, 0.0);
//        }
//
//        for(int i = 0; i < stages.length; i++) {
//            if (stages[i] <= n) {
//                double curr = map.get(stages[i]);
//                if (curr == 0.0){
//                    total = stages.length - i;
////                    double hap = curr + (double) 1 / total;
////                    System.out.println("!!!" + hap);
//                }
//                map.put(stages[i], curr + (double) 1 / total);
//            }
//        }
//
//        List<Map.Entry<Integer, Double>> entries = new LinkedList<>(map.entrySet());  // entries List <Map> 형식으로 생성
//        // value 에 대한 sort value reverseOrder
//        Collections.sort(entries, (o1, o2) -> Double.compare(o2.getValue(), o1.getValue())); // 내림차순
//
//        for (Map.Entry<Integer, Double> entry : entries) {
//            if (entry.getKey() <= n) {
//                answer.add(entry.getKey());
//            }
//        }
//        return answer.stream().mapToInt(i -> i).toArray();
//    }
}
