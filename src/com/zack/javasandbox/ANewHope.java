package com.zack.javasandbox;

/**
 * Class Description
 * Created on   3/11/16
 *
 * @author Zack Yao
 */
public class ANewHope {
	public static final int INVALID_INPUT = -1;
	public int count(int[] firstWeek, int[] lastWeek, int D) {
		int daysInWeek = firstWeek.length;
		if (daysInWeek != lastWeek.length) {
			return INVALID_INPUT;
		}

		return 1;
	}
}
