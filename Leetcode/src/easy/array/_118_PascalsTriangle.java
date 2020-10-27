package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle. Example:
 * 
 * Input: 5 
 * Output: [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 */
public class _118_PascalsTriangle {
	/*
	 * Solution_1 : 
	 */
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			row.add(0, 1);
			for (int j = 1; j < row.size() - 1; j++) {
				row.set(j, row.get(j) + row.get(j + 1));
			}
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
	}
	
	/*
	 * Solution_2 : 
	 */
	public static List<List<Integer>> generate_Sol_2(int numRows){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		// first base case
		if (numRows == 0) {
			return triangle;
		}
		// second base case; first row is always [1]
		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);
		
		for (int rowNum = 1; rowNum < numRows; rowNum++) { // 第二階之後才會進
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = triangle.get(rowNum - 1);
			// the first row element is always 1.
			row.add(1);
			for (int j = 1; j < rowNum; j++) {
				row.add(prevRow.get(j - 1) + prevRow.get(j));
			}
			// the last row element is always 1.
			row.add(1);
			triangle.add(row);
		}
		return triangle;
	}
	
	/*
	 * Solution_3 : recursive
	 */
	public static List<List<Integer>> generate_Sol_3(int numRows){
		List<List<Integer>> list = new ArrayList<>();
		generate_Sol_3(list, numRows);
		return list;
	}
	/* help method */
	public static void generate_Sol_3(List<List<Integer>> list, int numRows) {
		if (numRows == 1) {
			list.add(Arrays.asList(1));
		} else if (numRows > 1) {
			generate_Sol_3(list, numRows - 1);
			List<Integer> previousList = list.get(numRows - 2);
			List<Integer> thisList = new ArrayList<>();
			for (int i = 0; i < previousList.size(); i++) {
				if (i == 0) {
					thisList.add(1);
				}
				if (i > 0) {
					thisList.add(previousList.get(i) + previousList.get(i - 1));
				}
				if (i == previousList.size() - 1) {
					thisList.add(1);
				}
			}
			list.add(thisList);
		}
		
	}
	
	
	public static void main(String[] args) {
//		generate(5);
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(3, 5);
		System.out.println(list);
	}
}
