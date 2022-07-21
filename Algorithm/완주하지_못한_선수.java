import java.util.*;

class Solution {
    // 단 한명만 완주를 못함 
    public String solution(String[] participant, String[] completion) {
        //Set<String> map = new HashSet<>();
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) return participant[i];
        }
        
        return participant[participant.length-1];
    }
}

/**
    Arrays.sort(participant);
    Arrays.sort(completion);

    Map<String, Integer> map = new HashMap<>();

    for (String part : participant) {
//      if (!map.containsKey(part)) {
//        map.put(part, 1);
//      } else { // 중복 이름
//        map.replace(part, map.get(part) + 1);
//      }
      map.put(part, map.getOrDefault(part,0) + 1);
    }

    for(String comp : completion) {
      map.replace(comp, map.get(comp) - 1);
    }

    return map.entrySet().stream()
        .filter(m -> m.getValue() != 0)
        .map(Map.Entry::getKey)
        .findFirst().orElse(null);
    }
    **/
