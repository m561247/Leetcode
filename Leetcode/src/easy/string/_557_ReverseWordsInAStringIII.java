package easy.string;

/**
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1: 
 * Input: "Let's take LeetCode contest" 
 * Output: "s'teL ekat edoCteeL
 * tsetnoc" Note: In the string, each word is separated by single space and
 * there will not be any extra space in the string.
 * 
 *
 */
public class _557_ReverseWordsInAStringIII {
	/*
	 * Solution_1 : 直覺寫法
	 */
	public static String reverseWords_Sol_1(String s) {
		char[] chars;
		StringBuilder sb = new StringBuilder();
		for (String str : s.split(" ")) {
			chars = str.toCharArray();
			swap(chars, 0, chars.length - 1);
			sb.append(chars).append(" ");
		}
		String result = sb.toString().substring(0, sb.length() - 1);
		
		return result;
	}
	public static void swap(char[] chars, int start, int end) {
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}

	/*
	 * Solution_2
	 */
	public String reverseWords_Sol_2(String s) {
			char[] ca = s.toCharArray();
			for (int i = 0; i < ca.length; i++) {
				if (ca[i] != ' ') { // when i is a non-space
					int j = i;
					while (j + 1 < ca.length && ca[j + 1] != ' ') {
						j++; // 紀錄要交換的字串位置
					}
					reverse(ca, i, j);
					i = j;
				}
			}
			return new String(ca);
		}

		private void reverse(char[] ca, int i, int j) {
			for (; i < j; i++, j--) {
				char tmp = ca[i];
				ca[i] = ca[j];
				ca[j] = tmp;
			}
		}

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
	}
}