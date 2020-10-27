package easy.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * You are given an array A of strings.
 * 
 * A move onto S consists of swapping any two even indexed characters of S, or
 * any two odd indexed characters of S.
 * 
 * Two strings S and T are special-equivalent if after any number of moves onto
 * S, S == T.
 * 
 * For example, S = "zzxy" and T = "xyzz" are special-equivalent because we may
 * make the moves "zzxy" -> "xzzy" -> "xyzz" that swap S[0] and S[2], then S[1]
 * and S[3].
 * 
 * Now, a group of special-equivalent strings from A is a non-empty subset of A
 * such that:
 * 
 * Every pair of strings in the group are special equivalent, and; The group is
 * the largest size possible (ie., there isn't a string S not in the group such
 * that S is special equivalent to every string in the group) Return the number
 * of groups of special-equivalent strings from A.
 * 
 * 
 * Example 1:
 * 
 * Input: ["abcd","cdab","cbad","xyzz","zzxy","zzyx"] 
 * Output: 3 
 * Explanation: One
 * group is ["abcd", "cdab", "cbad"], since they are all pairwise special
 * equivalent, and none of the other strings are all pairwise special equivalent
 * to these.
 * 
 * The other two groups are ["xyzz", "zzxy"] and ["zzyx"]. Note that in
 * particular, "zzxy" is not special equivalent to "zzyx". 
 * 
 * Example 2:
 * 
 * Input: ["abc","acb","bac","bca","cab","cba"] 
 * Output: 3
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 1000 1 <= A[i].length <= 20 All A[i] have the same length.
 * All A[i] consist of only lowercase letters.
 * 
 * 題目說明 : 判斷輸入之字串陣列中的所有字串不同群組數量，若奇數索引、偶數索引可互換視為同一群組
 */
public class _893_GroupsOfSpecial_EquivalentStrings {
	/*
	 * Solution : 建立奇數、偶數陣列，再判斷該字元要放在哪個陣列中並且儲存該出現字元的出現次數
	 */
	public static int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String str : A) {
        	int[] odd = new int[26];
        	int[] even = new int[26];
        	for (int i = 0; i < str.length(); i++) {
        		//
        		if (i % 2 == 1) {
        			odd[str.charAt(i) - 'a']++;
        		} else {
        			even[str.charAt(i) - 'a']++;
        		}
        	}
        	String signature = Arrays.toString(odd) + Arrays.toString(even);
        	System.out.println(signature);
        	set.add(signature);
        }
        return set.size();
    }
	public static void main(String[] args) {
//		String[] strs = {"abc","acb","bac","bca","cab","cba"};
		String[] strs2 = {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
//		System.out.println(numSpecialEquivGroups(strs));
		System.out.println(numSpecialEquivGroups(strs2));
	}
}
