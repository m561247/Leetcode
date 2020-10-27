package easy.string;

import java.util.*;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we
 * can swap two letters in A so that the result equals B.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = "ab", B = "ba" Output: true 
 * 
 * Example 2:
 * 
 * Input: A = "ab", B = "ab" Output: false 
 * 
 * Example 3:
 * 
 * Input: A = "aa", B = "aa" Output: true 
 * 
 * Example 4:
 * 
 * Input: A = "aaaaaaabc", B = "aaaaaaacb" Output: true 
 * 
 * Example 5:
 * 
 * Input: A = "", B = "aa" Output: false
 * 
 * 
 * Constraints:
 * 
 * 0 <= A.length <= 20000 0 <= B.length <= 20000 A and B consist only of
 * lowercase letters.
 */

public class _859_BuddyString {
	/*
	 * Solution_1 : 
	 */
	public boolean buddyStrings_Sol_1(String A, String B) {
        if (A.length() != B.length()) {
        	return false;
        } else if (A.equals(B)) {
        	Set<Character> set = new HashSet<>();
        	for (char c : A.toCharArray()) {
        		set.add(c);
        	}
        	return set.size() < A.length();
        }
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) {
        	if (A.charAt(i) != B.charAt(i)) {
        		dif.add(i);
        	}
        }
        return dif.size() == 2 
        		&& A.charAt(dif.get(0)) == B.charAt(dif.get(1)) 
        		&& A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }
	
	/*
	 * Solution_2 : 
	 */
	public boolean buddyStrings_Sol_2(String A, String B) {
		if (A == null || B == null || A.length() != B.length()) {
			return false;
		}
		int a = -1, b = -1, diff = 0;
		int[] count = new int[26];
		boolean canSwitch = false;//判斷輸入的字串是不是都相同 ex : A = "aa", B = "aa"
		for (int i = 0; i < A.length(); i++) {
			if (++count[A.charAt(i) - 'a'] >= 2) {
				canSwitch = true;
			}
			if (A.charAt(i) != B.charAt(i)) {
				diff++;
				if (a == -1) {
					a = i;
				} else if (b == -1) {
					b = i;
				}
			}
		}
		return (diff == 0 && canSwitch) || 
				(diff == 2 && A.charAt(a) == B.charAt(b) && A.charAt(b) == B.charAt(a));
	}
	public static void main(String[] args) {
	}
}
