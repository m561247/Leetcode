package easy.string;

import java.util.HashMap;

/**
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their positions.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "ab-cd" Output: "dc-ba" Example 2:
 * 
 * Input: "a-bC-dEf-ghIj" 
 * Output: "j-Ih-gfE-dCba" 
 * 
 * Example 3:
 * 
 * Input: "Test1ng-Leet=code-Q!" 
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * Note:
 * 
 * S.length <= 100 
 * 33 <= S[i].ASCIIcode <= 122 
 * S doesn't contain \ or "
 */
public class _917_ReverseOnlyLetters {
	/*
	 * Solution_1 : two pointers
	 */
	public static String reverseOnlyLetters_Sol_1(String S) {//"ab-cd"
		StringBuilder sb = new StringBuilder(S);
		for (int i = 0, j = S.length() - 1; i <= j;) {
			if (!Character.isLetter(sb.charAt(i))) {
				i++;
			} else if (!Character.isLetter(sb.charAt(j))) {
				j--;
			} else {
				sb.setCharAt(i, S.charAt(j));
				sb.setCharAt(j, S.charAt(i));
				i++;
				j--;
			}
		}
		return sb.toString();
	}
	
	/*
	 * Solution_2 : StringBuilder裡的method
	 */
	public static String reverseOnlyLetters_Sol_2(String S) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (Character.isLetter(S.charAt(i))) {
				sb.append(S.charAt(i));
			}
		}
		sb.reverse();
		for (int i = 0; i < S.length(); i++) {
			if (!Character.isLetter(S.charAt(i))) {
				sb.insert(i, S.charAt(i));
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
	}
}
