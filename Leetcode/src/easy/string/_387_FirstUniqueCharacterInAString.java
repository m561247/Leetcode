package easy.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**\
 *找出第一個不重複的字元，並且返回他的索引值
 * 
 * Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 * @author user
 *
 */

public class _387_FirstUniqueCharacterInAString {
	/*
	 * Map作法，速度很慢
	 */
//	public static int firstUniqChar(String s) {
//		Map<Character, Integer> map = new LinkedHashMap<>();
//		int count, charIndex = -1;
//		for (Character c : s.toCharArray()) {
//			count = map.getOrDefault(c, 0) + 1;
//			map.put(c, count);
//			}
//		for (Character c : map.keySet()) {
//			if (map.get(c) == 1 && s.indexOf(c) > charIndex) {
//					charIndex = s.indexOf(c);
//					break;
//			}
//		}
//		return charIndex;
//	}
	
	/*
	 * twopointers一個紀錄所有字元出現次數，一個紀錄要返回的值
	 */
//	 public static int firstUniqChar(String s) {
//	        if(s == null || s.length() == 0) {
//	        	return -1;
//	        }
//	        int slow = 0,fast = 0;
//	        char[] cArray = s.toCharArray();
//	        int[] count = new int[256];
//	        int cLen = cArray.length;
//	        while (fast < cLen){
//	            count[cArray[fast]]++;//cArray[fast] = 'l'
//	            while (slow < cLen && count[cArray[slow]] > 1){//��fast�]�쭫�Ʀr��
//	                slow++;
//	            }
//	            if (slow == cLen) {
//	            	return -1;
//	            }
//	            fast++;
//	        }
//	        return slow;
//	    }
	/*
	 * �ɤO��
	 */
	public static int firstUniqChar(String s) {
	        int freq [] = new int[26];
	        for(int i = 0; i < s.length(); i ++)
	            freq [s.charAt(i) - 'a'] ++;
	        for(int i = 0; i < s.length(); i ++)
	            if(freq [s.charAt(i) - 'a'] == 1)
	                return i;
	        return -1;
	    }
	 
	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
		System.out.println('a' - 0);
	}
}
