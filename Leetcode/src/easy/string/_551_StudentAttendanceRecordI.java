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
 * Example 1: Input: "PPALLP" Output: True Example 2: Input: "PPALLL" Output:
 * False
 * 
 * @author user
 *
 */
public class _551_StudentAttendanceRecordI {
	/*
	 * using lib
	 */
//	public static boolean checkRecord(String s) {
//		return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
//	}
	/*
	 * without lib
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
	 * mayself Runtime: 1 ms, faster than 30.97% of Java online submissions for
	 * Student Attendance Record I. Memory Usage: 37.2 MB, less than 83.02% of Java
	 * online submissions for Student Attendance Record I.
	 */


	 
	  
	
//	public static boolean checkRecord(String s) {
//		char prev = '0';
//		char next = '0';
//		int countA = 0;
//		for (int i = 0; i < s.length() - 1; i++) {
//			next = s.charAt(i + 1);
//			if (s.charAt(i) == 'A') {
//				countA++;
//			} else if (prev == 'L' && s.charAt(i) == 'L' && next == 'L') {
//				return false;
//			}
//			prev = s.charAt(i);
//		}
//		if (s.charAt(s.length() - 1) == 'A') {
//			countA++;
//		}
//		return countA <= 1;
//	}
	public static void main(String[] args) {
		System.out.println(checkRecord("AA"));
	}
}
