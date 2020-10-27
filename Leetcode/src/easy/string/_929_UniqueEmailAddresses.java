package easy.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Every email consists of a local name and a domain name, separated by the @
 * sign.
 * 
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com
 * is the domain name.
 * 
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * 
 * If you add periods ('.') between some characters in the local name part of an
 * email address, mail sent there will be forwarded to the same address without
 * dots in the local name. For example, "alice.z@leetcode.com" and
 * "alicez@leetcode.com" forward to the same email address. (Note that this rule
 * does not apply for domain names.)
 * 
 * If you add a plus ('+') in the local name, everything after the first plus
 * sign will be ignored. This allows certain emails to be filtered, for example
 * m.y+name@email.com will be forwarded to my@email.com. (Again, this rule does
 * not apply for domain names.)
 * 
 * It is possible to use both of these rules at the same time.
 * 
 * Given a list of emails, we send one email to each address in the list. How
 * many different addresses actually receive mails?
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2 
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com"
 * actually receive mails
 * 
 * 
 * Note:
 * 
 * 1 <= emails[i].length <= 100 1 <= emails.length <= 100 Each emails[i]
 * contains exactly one '@' character. All local and domain names are non-empty.
 * Local names do not start with a '+' character.
 * 
 * 題目說明 : 判斷輸入的字串陣列中有多少個不同的E-mail
 * 			E-mail規則為local name中'.'會被無視，'+'的後面會被無視。
 */
public class _929_UniqueEmailAddresses {
	/*
	 * Soltion_1 : 一般解
	 */
	public static int numUniqueEmails_Sol_1(String[] emails) {
		Set<String> normalized = new HashSet<>();
		for (String email : emails) {
			String[] parts = email.split("@");
			String[] local = parts[0].split("\\+");
			normalized.add(local[0].replace(".", "") + "@" + parts[1]);
		}
		return normalized.size();
	}
	
	/*
	 * Solution_2 : 若遇到類似以下E-mail的話這個方法較好 :
	 * 				a+nadgkj.ansjfnakjn.gaskjgb.ubeijbg.kjn@g.com
	 */
	public static int numUniqueEmails_Sol_2(String[] emails) {
		Set<String> emailsSet = new HashSet<>();
		for (String email : emails) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < email.length(); i++) {
				if (email.charAt(i) == '.') {
					continue;
				} else if (email.charAt(i) == '+') {
					int eLength = email.length() - 1;
					while (email.charAt(eLength) != '@') {
						eLength--;
					}
					sb.append(email.substring(eLength));
					break;
				} else {
					sb.append(email.charAt(i));
				}
			}
			emailsSet.add(sb.toString());
		}
		return emailsSet.size();
	}
	public static void main(String[] args) {
		String[] emails = {"a+nadgkj.ansjfnakjn.gaskjgb.ubeijbg.kjn@g.com", "a+nadgkj.ansjfnakjn.gaskjgb.ubeijbg.kjn@g.com"};
		System.out.println(numUniqueEmails_Sol_2(emails));
	}
}
