package easy.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * 
 * Example 1:
 * Input: "()" 
 * Output: true 
 * 
 * Example 2:
 * Input: "()[]{}" 
 * Output: true 
 * 
 * Example 3:
 * Input: "(]" 
 * Output: false
 *  
 * Example 4:
 * Input: "([)]" 
 * Output: false
 *  
 * Example 5:
 * Input: "{[]}" 
 * Output: true
 */
public class _20_ValidParentheses {
	/*
	 * Solution_1 : use linked list
	 */
	public static boolean isValid_Sol_1(String s) {
        LinkedList<Character> linklist = new LinkedList<>();
        for (char c : s.toCharArray()) {
        	if (c == '(') {
        		linklist.addLast(')');
        		continue;
        	} else if (c == '[') {
        		linklist.addLast(']');
        		continue;
        	} else if (c == '{') {
        		linklist.addLast('}');
        		continue;
        	} else if (linklist.size() == 0) {
        		return false;
        	} else if (linklist.getLast() == c) {
        		linklist.removeLast();
        	} else {
        		return false;
        	}
        }
        return linklist.isEmpty();
    }
	
	/*
	 * Solution_2 : use stack
	 */
	public static boolean isValid_Sol_2(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		String s = "()";
		System.out.println(isValid_Sol_2(s));
	}
}
