package easy.string;

/**
 * Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced. *
Example 3:

Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
 */
public class _443_StringCompression { 
	public static int compress(char[] chars) {
        int indexAns = 0, index = 0;
        
        while (index < chars.length){
            char currentChar = chars[index];
            int count = 0;//紀錄多少個相同的char
            while (index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if (count != 1) {
            	for (char c : Integer.toString(count).toCharArray()) {
                	chars[indexAns++] = c;//
                }
            }
        }
        return indexAns;
    }
	public static void main(String[] args) {
		String str = "abbbbbbbbbbbbbbbbbb";
		compress(str.toCharArray());
	}
}
