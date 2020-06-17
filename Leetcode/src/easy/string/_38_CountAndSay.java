package easy.string;
/**
 * Example 1:

Input: 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: 4
Output: "1211"
Explanation: For n = 3 the term was "21" in which we have two groups "2" 
and "1", "2" can be read as "12" which means frequency = 1 and value = 2,
the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
 * @author user
 *
 */
public class _38_CountAndSay {
	public static String countAndSay(int n) {
		StringBuilder curr = new StringBuilder("1");
		StringBuilder prev;
		int count;
		char say;
		for (int i = 1; i < n; i++) {
			prev = curr;
			count = 1;
			curr = new StringBuilder();
			say = prev.charAt(0);
			for (int j = 1; j < prev.length(); j++) {
				if (prev.charAt(j) != say) {
					curr.append(count).append(say);
					count = 1;
					say = prev.charAt(j);
				} else
					count++;
			}
			curr.append(count).append(say);
		}
		return curr.toString();
	}
	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}

}
