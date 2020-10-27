package easy.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing
 * moving one unit north, south, east, or west, respectively. You start at the
 * origin (0, 0) on a 2D plane and walk on the path specified by path.
 * 
 * Return True if the path crosses itself at any point, that is, if at any time
 * you are on a location you've previously visited. Return False otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 *========圖片
 * 
 * Input: path = "NES" 
 * Output: false 
 * Explanation: Notice that the path doesn't
 * cross any point more than once. 
 * 
 * Example 2:
 * 
 *========圖片	
 * 
 * Input: path = "NESWW" 
 * Output: true 
 * Explanation: Notice that the path visits
 * the origin twice.
 * 
 * 
 * Constraints:
 * 
 * 1 <= path.length <= 10^4 path will only consist of characters in {'N', 'S',
 * 'E', 'W}
 */
public class _1496_PathCrossing {
	/*
	 * Solution : 用set記錄原點座標，記錄每個走過的座標
	 */
	public static boolean isPathCrossing(String path) {
		int x = 0, y = 0;
		Set<String> set = new HashSet<>();
		set.add(x + "," + y);
		for (char c : path.toCharArray()) {
			switch (c) {
				case 'N' :
					y++;
					break;
				case 'S' :
					y--;
					break;
				case 'E' :
					x++;
					break;
				case 'W' :
					x--;
					break;
			
			}
			String key = x + "," + y;
			if (set.contains(key)) {
				return true;
			}
			set.add(key);
		}
		return false;
    }
	public static void main(String[] args) {
		
	}
}
