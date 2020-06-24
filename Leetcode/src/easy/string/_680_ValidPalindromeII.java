package easy.string;
/**
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * @author user
 *
 */
public class _680_ValidPalindromeII {
	private static class UseLib {
		
	}
	private static class WithoutLib {
		  public boolean validPalindrome(String s) {
		        if (s.length () <= 1)
		            return true;
		        char[] chs = s.toCharArray ();
		        int lo = 0, hi = chs.length - 1;
		        while (lo <= hi && chs[lo] == chs[hi]) {
		            lo++;
		            hi--;
		        }
		        // If all match, then finish
		        if (lo > hi)
		            return true;
		        // LO2 represents the new LO if we skip [LO], and HI2 if we skip [HI]
		        int lo2 = lo + 1, hi2 = hi - 1;
		        // Will skipping [LO] make things work? 
		        while (lo2 <= hi && chs[lo2] == chs[hi]) {
		            lo2++;
		            hi--;
		        }
		        if (lo2 > hi)
		            return true;
		        // Will skipping [HI] make things work?
		        while (lo <= hi2 && chs[lo] == chs[hi2]) {
		            lo++;
		            hi2--;
		        }
		        if (lo > hi2)
		            return true;
		        // Doesn't work
		        return false;
		    }
	}
	public static void main(String[] args) {
		
	}
}
