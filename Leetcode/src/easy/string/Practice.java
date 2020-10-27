package easy.string;

import java.util.*;
/**
 *  * Example 1:
 * Input: "UD" Output: true Explanation: The robot moves up once, and then down
 * once. All moves have the same magnitude, so it ended up at the origin where
 * it started. Therefore, we return true.
 * 
 * 
 * Example 2:
 * Input: "LL" 
 * Output: false 
 */
public class Practice {
	 public boolean judgeCircle(String moves) {
		 int x = 0, y = 0;
		 for (int i = 0 ; i < moves.length(); i++) {
			 switch (moves.charAt(i)) {
			 	case 'R' :
			 		x++;
			 		break;
			 	case 'L' :
			 		x--;
			 		break;
			 	case 'U' :
			 		y++;
			 		break;
			 	case 'D' :
			 		y--;
			 		break;
			 }
		 }
		 return x == 0 && y == 0;
	 }
	
	
	
	public static void main(String[] args) {
	}
}