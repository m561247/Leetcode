package easy.string;

/**
 * Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 * @author user
 *
 */
public class _344_ReverseString {
	
	public static void reverseString(char[] s) {
		int lengHead = s.length / 2, lengTail = s.length - 1;
        for (int i = 0; i < lengHead; i++) {
        	char temp = s[i];
        	s[i] = s[lengTail];
        	s[lengTail] = temp;
        	lengTail--;
        }
        for (int i = 0; i < s.length; i++) {
        	System.out.print(s[i]);
        }
    }
	public static void main(String[] args) {
		String s = "Hello";
		String s2 = "fuck";
		reverseString(s2.toCharArray());
	}

}
