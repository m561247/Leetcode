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
	/*
	 * version1 : 使用API:Integer.toString
	 */
//	public static int compress(char[] chars) {
//        int indexAns = 0, index = 0;
//        
//        while (index < chars.length){
//            char currentChar = chars[index];
//            int count = 0;//紀錄多少個相同的char
//            while (index < chars.length && chars[index] == currentChar){
//                index++;
//                count++;
//            }
//            chars[indexAns++] = currentChar;
//            if (count != 1) {
//            	for (char c : Integer.toString(count).toCharArray()) {
//                	chars[indexAns++] = c;//
//                }
//            }
//        }
//        return indexAns;
//    }
	
	/*
	 * version2 : 改良自ver1，不使用API版
	 */
	public static int compress(char[] chars) {
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
	               int endIndexAns = indexAns; 
	               indexAns--; 	                
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
	 * ver3 
	 */
//	public int compress(char[] chars) {
//    int count = 1; 
//    int index = 0; 
//    for (int i = 0; i < chars.length; i++) {
//        while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
//            count++; 
//            i++; 
//        }
//        if (count == 1) {
//            chars[index++] = chars[i]; 
//        } else {
//            chars[index++] = chars[i]; 
//            String num = String.valueOf(count); 
//            for (int j = 0; j < num.length(); j++) {
//                chars[index++] = num.charAt(j); 
//            }
//        }
//        count = 1; 
//    }
//    return index; 
//}
	
	public static void main(String[] args) {
		compress("abbbbbbbbbbbb".toCharArray());
	}
}
