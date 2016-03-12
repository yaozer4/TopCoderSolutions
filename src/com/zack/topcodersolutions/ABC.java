package com.zack.topcodersolutions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Class Description
 * Created on   3/10/16
 *
 * @author Zack Yao
 */
public class ABC {
	private static final Map<Integer, String> VALUE_TO_CHAR;
	static {
		Map<Integer, String> tempMap = new HashMap<>();
		tempMap.put(0, "A");
		tempMap.put(1, "B");
		tempMap.put(2, "C");
		VALUE_TO_CHAR = Collections.unmodifiableMap(tempMap);
//		ABBBBBBBB
//		ABCABCABC
//		(0,1),
//		(0,2),
//		(1,2),
//		(0,4),
//		(0,5),
//		(3,4),
//		(3,5),
//		(0,7),
//		(0,8),
//		(3,7),
//		(3,8),
//		(5,6),
//		(5,7),
//		(6,7)
	}


	public String createString(int N, int K) {
		String result = "";
		int pairNums = 0;
		if (N==0) {
			return result;
		}
		// if K <= N-1 make C*N and change last char to B and move back K number of times
		for (int i=0; i<N; i++) {
			result += 'C';
		}
		while (pairNums <= K) {
			char lastChar = result.charAt(result.length()-1);
			int pairsRemaining = K - pairNums;
		}
		return result;
	}
}
