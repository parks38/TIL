import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String answer = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for(int j  = 1; j < strs.length; j++) {
                int leng = strs[j].length();
                if (i < leng && strs[0].charAt(i) == strs[j].charAt(i)) continue;
                else return answer;
            }
            answer += strs[0].charAt(i);
        }  
        
        return answer;
    }
}
