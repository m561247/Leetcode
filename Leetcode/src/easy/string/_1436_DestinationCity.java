package easy.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there
 * exists a direct path going from cityAi to cityBi. Return the destination
 * city, that is, the city without any path outgoing to another city.
 * 
 * It is guaranteed that the graph of paths forms a line without any loop,
 * therefore, there will be exactly one destination city.
 * 
 * 
 * 
 * Example 1:
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao
 * Paulo"]] 
 * Output: "Sao Paulo" 
 * Explanation: Starting at "London" city you will
 * reach "Sao Paulo" city which is the destination city. Your trip consist of:
 * "London" -> "New York" -> "Lima" -> "Sao Paulo". 
 * 
 * Example 2:
 * Input: paths = [["B","C"],["D","B"],["C","A"]] 
 * Output: "A" 
 * Explanation: All
 * possible trips are: "D" -> "B" -> "C" -> "A". "B" -> "C" -> "A". "C" -> "A".
 * "A". Clearly the destination city is "A". 
 * 
 * Example 3:
 * Input: paths = [["A","Z"]] 
 * Output: "Z"
 * 
 * 
 * Constraints:
 * 
 * 1 <= paths.length <= 100 paths[i].length == 2 1 <= cityAi.length,
 * cityBi.length <= 10 cityAi != cityBi All strings consist of lowercase and
 * uppercase English letters and the space character.
 * 
 * 題目說明 : 給一個 List 內含數個 List ，每個 List 中又含啟程、目的地兩字串，判斷最後的目的地為何
 */
public class _1436_DestinationCity {
	/*
	 * Solution_1 : use map
	 */
	public static String destCity_Sol_1(List<List<String>> paths) {
		Map<String, Boolean> map = new HashMap<>();
		for (List<String> lists : paths) {
			map.put(lists.get(0), false);
			if (!map.containsKey(lists.get(1))) {
				map.put(lists.get(1), true);
			}
		}
		for (String s : map.keySet()) {
			if (map.get(s)) {
				return s;
			}
		}
		return null;
    }
	
	/*
	 * Solution_2 : use set
	 */
	public static String desCity_Sol_2(List<List<String>> paths) {
		Set<String> set = new HashSet<>();
		String result = "";
		for (int i = 0; i < paths.size(); i++) {
			set.add(paths.get(i).get(0));
		}
		for (int i = 0; i < paths.size(); i++) {
			if (!set.contains(paths.get(i).get(1))) {
				result = paths.get(i).get(1);
				break;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("0");
		System.out.println(list.get(1));
	}
}
