import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> freqMap1 = new HashMap<>();
        Map<Character, Integer> freqMap2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            freqMap1.put(c1, freqMap1.getOrDefault(c1, 0) + 1);
            freqMap2.put(c2, freqMap2.getOrDefault(c2, 0) + 1);
        }

        if (!freqMap1.keySet().equals(freqMap2.keySet())) {
            return false;
        }

        Map<Integer, Integer> freqCount1 = new HashMap<>();
        Map<Integer, Integer> freqCount2 = new HashMap<>();

        for (int freq : freqMap1.values()) {
            freqCount1.put(freq, freqCount1.getOrDefault(freq, 0) + 1);
        }

        for (int freq : freqMap2.values()) {
            freqCount2.put(freq, freqCount2.getOrDefault(freq, 0) + 1);
        }

        return Objects.equals(freqCount1, freqCount2);
    }
}
