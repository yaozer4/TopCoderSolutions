package com.zack.topcoder.practice.solutions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Class Description
 * Created on   3/14/2016
 *
 * @author Zack Yao
 */
public class ANewHopeTest {
	private ANewHope aNewHope;

	public static final int[] TEST_ONE_FIRST_WEEK = new int[]{1, 2, 3, 4};
	public static final int[] TEST_TWO_FIRST_WEEK = new int[]{8, 5, 4, 1, 7, 6, 3, 2};
	public static final int[] TEST_THREE_FIRST_WEEK = new int[]{1, 2, 3, 4};

	public static final int[] TEST_ONE_LAST_WEEK = new int[]{4, 3, 2, 1};
	public static final int[] TEST_TWO_LAST_WEEK = new int[]{2, 4, 6, 8, 1, 3, 5, 7};
	public static final int[] TEST_THREE_LAST_WEEK = new int[]{1, 2, 3, 4};

	public static final int TEST_ONE_DAYS_TO_WASH = 3;
	public static final int TEST_TWO_DAYS_TO_WASH = 3;
	public static final int TEST_THREE_DAYS_TO_WASH = 2;

	public static final int TEST_ONE_RESULT = 4;
	public static final int TEST_TWO_RESULT = 3;
	public static final int TEST_THREE_RESULT = 1;

	@Before
	public void setUp() {
		aNewHope = new ANewHope();
	}

	@Test
	public void testCountOne() {
		Assert.assertEquals(TEST_ONE_RESULT, aNewHope.count(TEST_ONE_FIRST_WEEK, TEST_ONE_LAST_WEEK, TEST_ONE_DAYS_TO_WASH));
	}

	@Test
	public void testCountTwo() {
		Assert.assertEquals(TEST_TWO_RESULT, aNewHope.count(TEST_TWO_FIRST_WEEK, TEST_TWO_LAST_WEEK, TEST_TWO_DAYS_TO_WASH));
	}

	@Test
	public void testCountThree() {
		Assert.assertEquals(TEST_THREE_RESULT, aNewHope.count(TEST_THREE_FIRST_WEEK, TEST_THREE_LAST_WEEK, TEST_THREE_DAYS_TO_WASH));
	}
}
