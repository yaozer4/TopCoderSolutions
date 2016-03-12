package com.zack.topcodersolutions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Class Description
 * Created on   3/11/16
 *
 * @author Zack Yao
 */
public class ANDEquationTest {
	private ANDEquation andEquation;

	public static final int[] CASE_ONE = new int[]{1, 3, 5};
	public static final int[] CASE_TWO = new int[]{31, 7};
	public static final int[] CASE_THREE = new int[]{31, 7, 7};
	public static final int[] CASE_FOUR = new int[]{1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0, 0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,1};
	public static final int[] CASE_FIVE = new int[]{191411,256951,191411,191411,191411,256951,195507,191411,192435,191411, 191411,195511,191419,191411,256947,191415,191475,195579,191415,191411, 191483,191411,191419,191475,256947,191411,191411,191411,191419,256947, 191411,191411,191411};
	public static final int[] CASE_SIX = new int[]{1362,1066,1659,2010,1912,1720,1851,1593,1799,1805,1139,1493,1141,1163,1211};
	public static final int[] CASE_SEVEN = new int[]{2, 3, 7, 19};

	public static final int CASE_ONE_ANSWER = 1;
	public static final int CASE_THREE_ANSWER = 7;
	public static final int CASE_FOUR_ANSWER = 0;
	public static final int CASE_FIVE_ANSWER = 191411;

	public static final int INVALID_CASE_ANSWER = -1;

	@Before
	public void setUp() {
		andEquation = new ANDEquation();
	}

	@Test
	public void testRestoreYOne() {
		Assert.assertEquals(CASE_ONE_ANSWER, andEquation.restoreY(CASE_ONE));
	}

	@Test
	public void testRestoreYTwo() {
		Assert.assertEquals(INVALID_CASE_ANSWER, andEquation.restoreY(CASE_TWO));
	}

	@Test
	public void testRestoreYThree() {
		Assert.assertEquals(CASE_THREE_ANSWER, andEquation.restoreY(CASE_THREE));
	}

	@Test
	public void testRestoreYFour() {
		Assert.assertEquals(CASE_FOUR_ANSWER, andEquation.restoreY(CASE_FOUR));
	}

	@Test
	public void testRestoreYFive() {
		Assert.assertEquals(CASE_FIVE_ANSWER, andEquation.restoreY(CASE_FIVE));
	}

	@Test
	public void testRestoreYSix() {
		Assert.assertEquals(INVALID_CASE_ANSWER, andEquation.restoreY(CASE_SIX));
	}

	@Test
	public void testRestoreYSeven() {
		Assert.assertEquals(INVALID_CASE_ANSWER, andEquation.restoreY(CASE_SEVEN));
	}
}
