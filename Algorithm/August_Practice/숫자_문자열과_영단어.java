class Solution {
    public int solution (String s) {
        Map<String, Integer> numMap = new HashMap<String, Integer>();

        // num map 생성 하기 
        numMap.put("zero", 0);
        numMap.put("one", 1);
        numMap.put("two", 2);
        numMap.put("three", 3);
        numMap.put("four", 4);
        numMap.put("five", 5);
        numMap.put("six", 6);
        numMap.put("seven", 7);
        numMap.put("eight", 8);
        numMap.put("nine", 9);

        String answer = "";
        String tempWord = ""; // word 저장 

        for (int i = 0; i < s.length(); i++) {
            /**
                Character.digit()
                string.matches(pattern)
                Scanner.nextInt(radix)

                Character -> Integer
                   == Character.getNumericValue()
             */
            if (Character.isDigit(s.charAt(i))) {
                answer += s.charAt(i);
            } else { // 문자열 경우 
                tempWord += s.charAt(i);

                if (numMap.containsKey(tempWord)) {
                    answer += numMap.get(tempWord);
                    tempWord = ""; // 초기화 
                } 
            }
        }

        return Integer.parseInt(answer);
    }
}
