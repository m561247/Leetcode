package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0. 
 * 
 * Example:
 * 
 * Input: 3 
 * Output: [1,3,3,1]
 */
public class _119_PascalsTriangleII {
	/*
	 * Solution_1 : 與 Pascal's I 類似解法
	 */
	public static List<Integer> getRow_Sol_1(int rowIndex) {
		List<Integer> list = new ArrayList<>();
        if (rowIndex == 0) {
            list.add(1);
        	return list;
        }
        for (int i = 0; i < rowIndex; i++) {
        	List<Integer> temp = new ArrayList<>();
        	temp.add(1);
        	for (int j = 0; j < i; j++) { // 至少第三階才會進來
        		temp.add(j + 1, list.get(j) + list.get(j + 1));
        	}
        	temp.add(1);
        	list = temp;
        }
        return list;
    }
	
	/*
	 * Solution_2 : 
	 */
	public static List<Integer> getRow_Sol_2(int rowIndex){
		Integer[] arr = new Integer[rowIndex + 1];
		Arrays.fill(arr, 0);
		arr[0] = 1;
		for (int i = 0; i <= rowIndex; i++) {
			for (int j = i; j > 0; j--) {
				arr[j] = arr[j] + arr[j - 1];
			}
		}
		return Arrays.asList(arr);
	}
	
	
	
	
	public static void main(String[] args) {
		getRow_Sol_2(3);
	}
}
