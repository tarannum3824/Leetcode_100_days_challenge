import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Solution {
    public List<String> letterCombinations(String digits) { //Given digit in a string form like "23" is not digit here ..here it is in string form
    List<String> parinam = new ArrayList<>();
        if (digits.length() == 0) {
            return parinam;
        }

        HashMap<Character, String> HM = new HashMap<>();
        HM.put('2', "abc");
        HM.put('3', "def");
        HM.put('4', "ghi");
        HM.put('5', "jkl");
        HM.put('6', "mno");
        HM.put('7', "pqrs");
        HM.put('8', "tuv");
        HM.put('9', "wxyz");

        backtrack(digits, 0, HM, new StringBuilder(), parinam);
        return parinam;
    }

    private static void backtrack(String digits, int i, HashMap<Character, String> HM, StringBuilder sb, List<String> parinam) {
        if (i == digits.length()) {
            parinam.add(sb.toString());
            return;
        }

        String current = HM.get(digits.charAt(i));
        for (int a = 0; a < current.length(); a++) {
            sb.append(current.charAt(a));
            backtrack(digits, i + 1, HM, sb, parinam);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}