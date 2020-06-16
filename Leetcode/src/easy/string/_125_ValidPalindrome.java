package easy.string;
/**
 * Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 * @author user
 *
 */
public class _125_ValidPalindrome {
	public static boolean isPalindrome(String s) {
		int head = 0, tail = s.length() - 1;
		char cHead, cTail;
		
		while (tail >= head) {
			cHead = s.charAt(head);
			cTail = s.charAt(tail);
			if (!Character.isLetterOrDigit(cHead)) head++;
			else if (!Character.isLetterOrDigit(cTail)) cTail--;
			
		}
		return false ; 
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("abcdedcba"));
	}
}
