package easy.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * You have an array of logs. Each log is a space delimited string of words.
 * 
 * For each log, the first word in each log is an alphanumeric identifier. Then,
 * either:
 * 
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits. We will call
 * these two varieties of logs letter-logs and digit-logs. It is guaranteed that
 * each log has at least one word after its identifier.
 * 
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the
 * identifier used in case of ties. The digit-logs should be put in their
 * original order.
 * 
 * Return the final order of the logs.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit
 * dig","let3 art zero"] 
 * Output: ["let1 art can","let3 art zero","let2 own kit
 * dig","dig1 8 1 5 1","dig2 3 6"]
 * 
 * 
 * Constraints:
 * 
 * 0 <= logs.length <= 100 
 * 3 <= logs[i].length <= 100 
 * logs[i] is guaranteed to
 * have an identifier, and a word after the identifier.
 * 
 * 題目說明 : 排序一組logs字串陣列，字母-log、數字-log，字母log要排在數字log前面
 * 			字母log要照其字母順序排序，數字log則保持原本的排序
 */
public class _937_ReorderDataInLogFiles {
	/*
	 * Solution_1 : 
	 */
	public String[] reorderLogFiles(String[] logs) {
        if(logs.length <=0) {
        	return logs;
        }
        List<String> letterL = new ArrayList<>();
        List<String> digL = new ArrayList<>();
        for (String str : logs) {
            String[] sList = str.split(" ");
            if (Character.isDigit(sList[1].charAt(0))) {
                digL.add(str);
            } else {
                letterL.add(str);
            }
        }
        Collections.sort(letterL, (a, b) -> {
            String s1 = a.substring(a.indexOf(" ") + 1);
            String s2 = b.substring(b.indexOf(" ") + 1);
            return s1.equals(s2) ? a.compareTo(b) : s1.compareTo(s2);
        });
        letterL.addAll(digL);
        return letterL.toArray(new String[letterL.size()]);
    }
	
	/*
	 * Solution_2 : 自訂比較器
	 */
	public static String[] reorderLogFiles_Sol_2(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
//            	System.out.println("s1 = " + s1);
//            	System.out.println("s2 = " + s2);
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
//                System.out.println("s1SpaceIndex = " + s1SpaceIndex);
//                System.out.println("s2SpaceIndex = " + s2SpaceIndex);
                char s1FirstCharacter = s1.charAt(s1SpaceIndex+1);
                char s2FirstCharacter = s2.charAt(s2SpaceIndex+1);
//                System.out.println("s1FirstCharacter = " + s1FirstCharacter);
//                System.out.println("s2FirstCharacter = " + s2FirstCharacter);
                //s1為數字
                if (s1FirstCharacter <= '9') {
                    if (s2FirstCharacter <= '9') {
                    	return 0;
                    } else {
                    	return 1;
                    }
                }
                //s1為字母且s2為數字
                if (s2FirstCharacter <= '9') {
                	return -1;
                }
                int preCompute = s1.substring(s1SpaceIndex+1).compareTo(s2.substring(s2SpaceIndex+1));
                if (preCompute == 0) {
                	return s1.substring(0,s1SpaceIndex).compareTo(s2.substring(0,s2SpaceIndex));
                }
                return preCompute;
            }
        };
        //由小到大排列
        Arrays.sort(logs, myComp);
        return logs;
    }
	public static void main(String[] args) {
		String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
//		String[] sortedLogs = reorderLogFiles_Sol_2(logs);
//		for (String s : sortedLogs) {
//			System.out.println(s);
//		}
		
	}
}
