class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalLength; i++) {
            String substring = s.substring(i, i + totalLength);
            if (isConcatenated(substring, wordCountMap, wordLength)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isConcatenated(String substring, Map<String, Integer> wordCountMap, int wordLength) {
        Map<String, Integer> currentMap = new HashMap<>();

        for (int i = 0; i < substring.length(); i += wordLength) {
            String word = substring.substring(i, i + wordLength);
            currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
        }

        return currentMap.equals(wordCountMap);
    }
}