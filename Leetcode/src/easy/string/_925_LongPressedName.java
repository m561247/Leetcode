package easy.string;

/**
 * Your friend is typing his name into a keyboard. Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 * 
 * You examine the typed characters of the keyboard. Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: name = "alex", typed = "aaleex" 
 * 
 * Output: true 
 * Explanation: 'a' and 'e'
 * in 'alex' were long pressed. 
 * 
 * Example 2:
 * 
 * Input: name = "saeed", typed = "ssaaedd" 
 * 
 * Output: false 
 * Explanation: 'e' must
 * have been pressed twice, but it wasn't in the typed output. 
 * 
 * Example 3:
 * 
 * Input: name = "leelee", typed = "lleeelee" 
 * 
 * Output: true 
 * 
 * Example 4:
 * 
 * Input: name = "laiden", typed = "laiden" 
 * 
 * Output: true 
 * Explanation: It's not
 * necessary to long press any character.
 * 
 * 
 * Constraints:
 * 
 * 1 <= name.length <= 1000 1 <= typed.length <= 1000 The characters of name and
 * typed are lowercase letters.
 * 
 * 題目說明 : 判斷typed經過壓縮(註 : 因為某些字元重複，要忽略重複的字元)後是否可以成為name
 */
public class _925_LongPressedName {
	/*
	 * Solution_1 : two pointers
	 */
	public static boolean isLongPressedName_Sol_1(String name, String typed) {
        //Input: name = "leelee", typed = "lleeelee" true
		int i = 0, m = name.length(), n = typed.length();
		for (int j = 0; j < n; ++j) {
			if (i < m && name.charAt(i) == typed.charAt(j)) {
				++i;
			} else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
				return false;
			}
		}
		return i == m;
    }
	
	/*
	 * Solution_2 : another two pointers，判斷是否兩個字串都可以全部跑完最外面的while迴圈
	 */
	public static boolean isLongPressedName_Sol_2(String name, String typed) {
		//Input: name = "leelee", typed = "lleeelee" true
		int m = name.length(), n = typed.length();
		int i = 0, j = 0;
		while (i < m && j < n) {
			char c1 = name.charAt(i), c2 = typed.charAt(j);
			if (c1 != c2) {
				return false;
			}
			int count1 = 0;//count的用意 : 計算重複出現的字元數量
			while (i < m && name.charAt(i) == c1) {
				count1++;
				i++;
			}
			int count2 = 0;//count的用意 : 計算重複出現的字元數量
			while (j < n && typed.charAt(j) == c2) {
				count2++;
				j++;
			}
			if (count2 < count1) {
				return false;
			}
		}
		return i == m && j == n;
	}
	public static void main(String[] args) {
		System.out.println(isLongPressedName_Sol_2("leelee", "lleeelee"));
	}
}
