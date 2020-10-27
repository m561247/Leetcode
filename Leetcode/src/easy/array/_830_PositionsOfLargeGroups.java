package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of
 * the same character.
 * 
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx",
 * "z" and "yy".
 * 
 * Call a group large if it has 3 or more characters. We would like the starting
 * and ending positions of every large group.
 * 
 * The final answer should be in lexicographic order.
 * 
 * 
 * 
 * Example 1:
 * Input: "abbxxxxzzy" 
 * Output: [[3,6]] 
 * Explanation: "xxxx" is the single large
 * group with starting 3 and ending positions 6. 
 * 
 * Example 2:
 * Input: "abc" 
 * Output: [] 
 * Explanation: We have "a","b" and "c" but no large
 * group. 
 * 
 * Example 3:
 * Input: "abcdddeeeeaabbbcd" 
 * Output: [[3,5],[6,9],[12,14]]
 * 
 * 
 * Note: 1 <= S.length <= 1000
 */
public class _830_PositionsOfLargeGroups {
	/*
	 * Solution_1 : by myself
	 */
	public static List<List<Integer>> largeGroupPositions(String S) { // abcdddeeeeaabbbcd
        List<List<Integer>> result = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < S.length(); i++) {
        	List<Integer> list = new ArrayList<>();
        	list.add(i);
        	while (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) {
        		i++;
        		count++;
        	}
        	list.add(i);
        	if (count >= 3) {
        		result.add(list);
        	}
        	count = 1;
        }
        return result;
    }
	
	/*
	 * Solution_2 : concise
	 */
	public List<List<Integer>> largeGroupPositions_Sol_2(String S) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0, j = 0; i < S.length(); i = j) {
            while (j < S.length() && S.charAt(j) == S.charAt(i)) ++j;
            if (j - i >= 3)
                res.add(Arrays.asList(i, j - 1));
        }
        return res;
    }
	public static void main(String[] args) {
		String s = "abc";
		System.out.println(largeGroupPositions(s));
	}
}
