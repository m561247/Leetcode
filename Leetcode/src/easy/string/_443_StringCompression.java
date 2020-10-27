package easy.string;

/**
 * Given an array of characters, compress it in-place.
 * 
 * The length after compression must always be smaller than or equal to the
 * original array.
 * 
 * Every element of the array should be a character (not int) of length 1.
 * 
 * After you are done modifying the input array in-place, return the new length
 * of the array.
 * 
 * 
 * Follow up: Could you solve it using only O(1) extra space?
 * 
 * 
 * Example 1:
 * 
 * Input: ["a","a","b","b","c","c","c"]
 * 
 * Output: Return 6, and the first 6 characters of the input array should be:
 * ["a","2","b","2","c","3"]
 * 
 * Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is
 * replaced by "c3".
 * 
 * 
 * Example 2:
 * 
 * Input: ["a"]
 * 
 * Output: Return 1, and the first 1 characters of the input array should be:
 * ["a"]
 * 
 * Explanation: Nothing is replaced.
 * 
 * 
 * Example 3:
 * 
 * Input: ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 
 * Output: Return 4, and the first 4 characters of the input array should be:
 * ["a","b","1","2"].
 * 
 * Explanation: Since the character "a" does not repeat, it is not compressed.
 * "bbbbbbbbbbbb" is replaced by "b12". Notice each digit has it's own entry in
 * the array.
 * 
 * 
 * Note:
 * 
 * All characters have an ASCII value in [35, 126]. 1 <= len(chars) <= 1000.
 */
public class _443_StringCompression {
	/*
	 * Solution_1 : Integer.toString
	 */
	public static int compress_Sol_1(char[] chars) {
		int indexAns = 0, index = 0;

		while (index < chars.length) {
			char currentChar = chars[index];
			int count = 0;// 紀錄多少個相同的char
			while (index < chars.length && chars[index] == currentChar) {
				index++;
				count++;
			}
			chars[indexAns++] = currentChar;
			if (count != 1) {
				for (char c : Integer.toString(count).toCharArray()) {
					chars[indexAns++] = c;
				}
			}
		}
		return indexAns;
	}

	/*
	 * Solution_2 :
	 */
	public static int compress_Sol_2(char[] chars) {
		int index = 0, indexAns = 0;

		while (index < chars.length) {
			char current = chars[index];
			int count = 0;

			while (index < chars.length && current == chars[index]) {
				index++;
				count++;
			}
			chars[indexAns++] = current;

			if (count != 1) {
				int startIndexAns = indexAns;

				while (count != 0) {
					chars[indexAns++] = (char) ((count % 10) + '0');
					count /= 10;
				}
				int endIndexAns = indexAns--;
				while (startIndexAns < indexAns) {
					char temp = chars[startIndexAns];
					chars[startIndexAns++] = chars[indexAns];
					chars[indexAns--] = temp;
				}
				indexAns = endIndexAns;
			}
		}
		return indexAns;
	}

	/*
	 * Solution_3 :
	 */
	public int compress_Sol_3(char[] chars) {
		int count = 1;
		int index = 0;
		for (int i = 0; i < chars.length; i++) {
			while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
				count++;
				i++;
			}
			if (count == 1) {
				chars[index++] = chars[i];
			} else {
				chars[index++] = chars[i];
				String num = String.valueOf(count);
				for (int j = 0; j < num.length(); j++) {
					chars[index++] = num.charAt(j);
				}
			}
			count = 1;
		}
		return index;
	}

	public static void main(String[] args) {
		System.out.println(compress_Sol_2("aasasasbbbbbbbb".toCharArray()));
	}
}
