package easy.string;

import java.util.HashSet;
import java.util.Stack;

/**
 * 
 * 
 * 
 * public String reverseVowels(String s) { if(s == null || s.length()==0) return
 * s; String vowels = "aeiouAEIOU"; char[] chars = s.toCharArray(); int start =
 * 0; int end = s.length()-1; while(start<end){
 * 
 * while(start<end && !vowels.contains(chars[start]+"")){ start++; }
 * 
 * while(start<end && !vowels.contains(chars[end]+"")){ end--; }
 * 
 * char temp = chars[start]; chars[start] = chars[end]; chars[end] = temp;
 * 
 * start++; end--; } return new String(chars); }
 * 
 * 
 * Example 1:
 * 
 * Input: "hello" 
 * Output: "holle" 
 * 
 * Example 2:
 * Input: "leetcode" 
 * Output: "leotcede"
 * 
 *
 */
public class _345_ReverseVowelsOfAString {
	/*
	 * Solution_1 : by myself
	 */
	public static String reverseVowels_Sol_1(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String vowels = "aeiouAEIOU";
		char[] c = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			while (start < end && vowels.indexOf(c[start]) == -1) {
				start++;
			}
			while (start < end && vowels.indexOf(c[end]) == -1) {
				end--;
			}
			char temp = c[start];
			c[start] = c[end];
			c[end] = temp;
			start++;
			end--;
		}
		return new String(c);
	}
	/*
	 * Solution_2 : use stack
	 */
	public static String reverseVowels_Sol_2(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String vowels = "AEIOUaeiou";
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (vowels.contains(c + "")) {
				stack.push(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (vowels.contains(c + "")) {
				sb.append(stack.pop());
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "leetcode";
		String s2 = "Hello";
	}
}
