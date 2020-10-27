package easy.string;

/**
 * Given a string text, you want to use the characters of text to form as many
 * instances of the word "balloon" as possible.
 * 
 * You can use each character in text at most once. Return the maximum number of
 * instances that can be formed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: text = "nlaebolko" 
 * Output: 1 
 * 
 * Example 2:
 * 
 * Input: text = "loonbalxballpoon" 
 * Output: 2 Example 3:
 * 
 * Input: text = "leetcode" Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= text.length <= 10^4 text consists of lower case English letters only.
 */
public class _1189_MaximumNumberOfBalloons {
	/*
	 * Solution_1 : 利用出現 balloon 的次數不可能出過自身長度的特性
	 * 				拿自身長度跟出現 "b"、"a"、"l"、"l"、"o"、"o"、"n" 相比，必定是出現字母數較小
	 */
	public static int maxNumberOfBalloons_Sol_1(String text) {
        int[] count = new int[26], countBalloon = new int[26];
        for (int i = 0; i < text.length(); i++) {
        	++count[text.charAt(i) - 'a'];
        }
        int min = text.length();
        for (char c : "balloon".toCharArray()) {
        	++countBalloon[c - 'a'];
        }
        for (char c : "balloon".toCharArray()) {
        	min = Math.min(min, count[c - 'a'] / countBalloon[c - 'a']);
        }
        return min;
    }
	
	/*
	 * Solution_2 : switch case
	 */
	public static int maxNumberOfBallons_Sol_2(String text) {
		int b = 0, a = 0, l = 0, o = 0, n = 0;
		for (char c : text.toCharArray()) {
			switch (c) {
				case 'b' :
					b++;
					break;
				case 'a' :
					a++;
					break;
				case 'l' :
					l++;
					break;
				case 'o' :
					o++;
					break;
				case 'n' :
					n++;
					break;
			}
		}
		return Math.min(b, Math.min(a, Math.min(l / 2, Math.min(o / 2, n))));
	}
	
	public static void main(String[] args) {
		String text = "baloon";
		System.out.println(maxNumberOfBallons_Sol_2(text));
	}
}
