package easy.math;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Return True if n is a happy number, and False if not.
 * 
 * Example:
 * Input: 19 
 * Output: true 
 * Explanation: 
 * 1(2) + 9(2) = 82 
 * 8(2) + (2)(2) = 68 
 * 6(2) + 8(2) = 100
 * 1(2) + 0(2) + 0(2) = 1
 */
public class _202_HappyNumber {
	/*
	 * Solution_1 : 快慢指針, 若非 happy number, ex : 11，會一直在某個數循環。
	 */
	public static boolean isHappy_Sol_1(int n) {
		int slow, fast;
		slow = fast = n;
		do {
			slow = digitSquareSum(slow);
			fast = digitSquareSum(digitSquareSum(fast));
		} while (slow != fast);
		if (slow == 1) {
			return true;
		} else {
			return false;
		}
	}
	/* help method */
	public static int digitSquareSum(int n) {
		int sum = 0, temp;
		while (n != 0) {
			temp = n % 10;
			sum += temp * temp;
			n /= 10;
		}
		return sum;
	}
	
	/*
	 * Solution_2 : 使用 hashset 紀錄
	 */
	public boolean isHappy_Sol_2(int n) {
		Set<Integer> inLoop = new HashSet<>();
		int squareSum, remain;
		while (inLoop.add(n)) {
			squareSum = 0;
			while (n > 0) {
				remain = n % 10;
				squareSum += remain * remain;
				n /= 10;
			}
			if (squareSum == 1) {
				return true;
			} else {
				n = squareSum;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		System.out.println(set.add(1));
	}
	
}
