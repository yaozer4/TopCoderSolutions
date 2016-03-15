package com.zack.topcoder.practice.solutions;

/**
 * Class Description
 * Created on   3/11/16
 *
 * @author Zack Yao
 */
public class ANDEquation {
	public int restoreY(int[] A) {
		for (int i=0; i<A.length; i++) {
			int potentialY = A[i];
			int andedResult = -1;
			A[i] = -1;
			for (int j=0; j<A.length; j++) {
				if (A[j] == -1) {
					continue;
				} else if (andedResult == -1) {
					andedResult = A[j];
				} else {
					andedResult &= A[j];
				}
			}
			if (potentialY == andedResult) {
				return potentialY;
			} else {
				A[i] = potentialY;
			}
		}
		return -1;
	}
}
