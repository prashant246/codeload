package leetcode;

import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeating {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 1) {
                return 1;
            }
            HashMap<Character, Integer> latestOccurenceMap = new HashMap();
            int checkPoint = 0;
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (latestOccurenceMap.containsKey(currentChar)) {
                    if (latestOccurenceMap.get(currentChar) >= checkPoint) {
                        int curLen = i - checkPoint;
                        checkPoint = latestOccurenceMap.get(currentChar) + 1;
                        ans = ans > curLen ? ans : curLen;
                    }
                }
                latestOccurenceMap.put(currentChar, i);
            }
            int temp = s.length() - checkPoint;
            ans = ans > temp ? ans : temp;
            return ans;
        }
    }
}
