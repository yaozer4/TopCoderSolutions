package com.zack.topcodersolutions;

/**
 * Class Description
 * Created on   3/10/16
 *
 * @author Zack Yao
 */
public class ABBA {
	public static final String POSSIBLE = "Possible";
	public static final String IMPOSSIBLE = "Impossible";

	public String canObtain(String initial, String target) {
		if (initial == null) {
			return IMPOSSIBLE;
		}
		if (initial.isEmpty()) {
			return POSSIBLE;
		}
		if (initial.equals(target)) {
			return POSSIBLE;
		} else if (initial.length() >= target.length()) {
			return IMPOSSIBLE;
		} else {
			while (target.length() > initial.length()) {
				char lastChar = target.charAt(target.length()-1);
				if (lastChar == 'A') {
					target = reverseMoveOne(target);
				} else if (lastChar == 'B') {
					target = reverseMoveTwo(target);
				}
			}
			return (initial.equals(target) ? POSSIBLE : IMPOSSIBLE);
		}
	}

	public String reverseMoveOne(String target) {
		return target.substring(0, target.length()-1);
	}

	public String reverseMoveTwo(String target) {
		char[] charRep = target.substring(0, target.length()-1).toCharArray();
		int cursor1 = 0;
		int cursor2 = charRep.length - 1;
		while (cursor1 <= cursor2) {
			char temp = charRep[cursor1];
			charRep[cursor1++] = charRep[cursor2];
			charRep[cursor2--] = temp;
		}
		return new String(charRep);
	}
}
