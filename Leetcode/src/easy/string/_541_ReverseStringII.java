package easy.string;

/**
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original. 
 * Example: 
 * Input: s = "abcdefg", k = 2 
 * Output: "bacdfeg" 
 * Restrictions: The string consists of lower English
 * letters only.
 */

public class _541_ReverseStringII {
	/*
	 * Solution_1 : 
	 */
	public static String reverseStr_Sol_1(String s, int k) {
		char[] c = s.toCharArray();
		int index = 0;
		while (index < c.length) {
			if (index + k - 1 < c.length) {
				reverse(c, index, index + k - 1);
			} else {
				reverse(c, index, c.length - 1);
			}
			index += 2 * k;
		}
		return new String(c);
	}

	public static void reverse(char[] c, int start, int end) {
		while (start < end) {
			char temp = c[start];
			c[start] = c[end];
			c[end] = temp;
			start++;
			end--;
		}
	}
	/*
	 * Solution_2 : 
	 */
      public static String reverseStr_Sol_2(String s, int k) {
        if (s == null || s.length() == 0) {
        	return s;
        }
        char[] cArr = reverseHelper(s.toCharArray(), 0, k);
        return String.valueOf(cArr);
    }
    
    private static char[] reverseHelper(char[] cArr, int start, int len) {
    	int temp = start;
        int end = Math.min(start + len - 1, cArr.length - 1);
        if (start >= cArr.length - 1) {
        	return cArr;
        }
        while (start < end) {
            char tmp = cArr[start];
            cArr[start] = cArr[end];
            cArr[end] = tmp;
            start++;
            end--;
        }
        temp += 2 * len;
        return reverseHelper(cArr, temp, len);
    }

	public static void main(String[] args) {
		System.out.println(reverseStr_Sol_2("abcdefg", 2));
	}
}
