import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store groups of anagrams
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Iterate through each string in the input array
        for (String str : strs) {
            // Convert the string to a char array, sort it, and convert it back to a string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Check if the sorted string is already a key in the HashMap
            // If not, add a new key-value pair with an empty list as the initial value
            anagramGroups.putIfAbsent(sortedStr, new ArrayList<>());

            // Add the original string to the list corresponding to the sorted string
            anagramGroups.get(sortedStr).add(str);
        }

        // Convert the values of the HashMap to a list and return
        return new ArrayList<>(anagramGroups.values());
    }
}
