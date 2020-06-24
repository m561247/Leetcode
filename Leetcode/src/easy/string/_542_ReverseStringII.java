package easy.string;

/**
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
 * @author user
 *
 */



public class _542_ReverseStringII {
	/*
	 * 一般版
	 */
	public static String reverseStr(String s, int k) {   
        char [] c = s.toCharArray();
        int index = 0;
        while (index < c.length){
           if (index + k - 1 < c.length) {
               reverse(c, index, index + k - 1);    
           } else {
               reverse(c, index, c.length - 1);
           }    
           index += 2 * k;
        }      
        return new String(c);
    }
    public static void reverse(char[] c, int start, int end){
    	while (start < end) {
    		char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }
    /*
     * 遞迴版
     */
//      public static String reverseStr(String s, int k) {
//        if (s == null || s.length() == 0) {
//        	return s;
//        }
//        char[] cArr = reverseHelper(s.toCharArray(), 0, k);
//        return String.valueOf(cArr);
//    }
//    
//    
//    private static char[] reverseHelper(char[] cArr, int start, int len) {
//    	int temp = start;
//        int end = Math.min(start + len - 1, cArr.length-1);
//        if (start > cArr.length) {
//    		return cArr;
//    	}
//        while (start < end) {
//            char tmp = cArr[start];
//            cArr[start] = cArr[end];
//            cArr[end] = tmp;
//            start++;
//            end--;
//        }
//        temp += 2 * len;
//        return reverseHelper(cArr, temp, len);
//    }
    
    
    
    
	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg", 2));
	}
}
