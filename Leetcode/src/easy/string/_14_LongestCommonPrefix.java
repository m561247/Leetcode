package easy.string;

public class _14_LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
	    if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    while(i < strs.length){
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length() - 1);
	        
	        if (pre.length() == 0) {
	            return "";
	        } else {
	            i++;
	        }
	    }
	    return pre;
	}

	public static void main(String[] args) {
		String[] strs = { "dog", "flower", "flight" };
		System.out.println(longestCommonPrefix(strs));
	}

}
