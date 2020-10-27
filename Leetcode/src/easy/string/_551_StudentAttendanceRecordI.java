package easy.string;

/**
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters: 'A' : Absent. 'L' :
 * Late. 'P' : Present. A student could be rewarded if his attendance record
 * doesn't contain more than one 'A' (absent) or more than two continuous 'L'
 * (late).
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1: 
 * Input: "PPALLP" 
 * Output: True 
 * 
 * Example 2: 
 * Input: "PPALLL" 
 * Output: False
 */
public class _551_StudentAttendanceRecordI {
	/*
	 * Solution_1
	 */
//	public static boolean checkRecord(String s) {
//		return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
//	}
	/*
	 * Solution_2
	 */
	public static boolean checkRecord(String s) {
		int countA = 0;
		int continuosL = 0;
		int charA = 'A';
		int charL = 'L';
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == charA) {
				countA++;
				continuosL = 0;
			} else if (s.charAt(i) == charL) {
				continuosL++;
			} else {
				continuosL = 0;
			}
			if (countA > 1 || continuosL > 2) {
				return false;
			}
		}
		return true;
	}
	/*
	 * Solution_2 : 暴力破解
	 */
	public static boolean checkRecord_Sol_2(String s) {
		char[] chars = s.toCharArray();
		int countA = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 'A') {
				countA++;
			}
			if (chars.length - i >= 3 && chars[i] == 'L' && chars[i + 1] == 'L' && chars[i + 2] == 'L') {
				return false;
			}
		}
		if (countA > 1) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkRecord("AA"));
	}
}
