package easy.array;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has enough space (size that is equal
 * to m + n) to hold additional elements from nums2. Example:
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 * Constraints:
 * 
 * -10^9 <= nums1[i], nums2[i] <= 10^9 nums1.length == m + n nums2.length == n
 */
public class _88_MergeSortedArray {
	/*
	 * Solution : 從後面開始比較，依題目所述，由 nums2 併到 nums1
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) { // [1,2,3,0,0,0] [2,5,6]
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		}
		while (j >= 0) { // nums1 全部都大於 nums2 的情況
			nums1[k--] = nums2[j--];
		}
    }
	public static void main(String[] args) {
		
	}
}
