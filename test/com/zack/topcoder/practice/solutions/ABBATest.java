package com.zack.topcoder.practice.solutions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Class Description
 * Created on   3/11/16
 *
 * @author Zack Yao
 */
public class ABBATest {
	private ABBA abba;

	public static final String TEST_ONE_INITIAL = "B";
	public static final String TEST_ONE_TARGET = "ABBA";
	public static final String TEST_TWO_INITIAL = "AB";
	public static final String TEST_TWO_TARGET = "ABB";
	public static final String TEST_THREE_INITIAL = "BBAB";
	public static final String TEST_THREE_TARGET = "ABABABABB";
	public static final String TEST_FOUR_INITIAL = "BBBBABABBBBBBA";
	public static final String TEST_FOUR_TARGET = "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA";
	public static final String TEST_FIVE_INITIAL = "A";
	public static final String TEST_FIVE_TARGET = "BB";

	@Before
	public void setUp() {
		abba = new ABBA();
	}

	@Test
	public void testCanObtainOne() {
		Assert.assertEquals(ABBA.POSSIBLE, abba.canObtain(TEST_ONE_INITIAL, TEST_ONE_TARGET));
	}
	
	@Test
	public void testCanObtainTwo() {
		Assert.assertEquals(ABBA.IMPOSSIBLE, abba.canObtain(TEST_TWO_INITIAL, TEST_TWO_TARGET));
	}
	
	@Test
	public void testCanObtainThree() {
		Assert.assertEquals(ABBA.IMPOSSIBLE, abba.canObtain(TEST_THREE_INITIAL, TEST_THREE_TARGET));
	}
	
	@Test
	public void testCanObtainFour() {
		Assert.assertEquals(ABBA.POSSIBLE, abba.canObtain(TEST_FOUR_INITIAL, TEST_FOUR_TARGET));
	}
	
	@Test
	public void testCanObtainFive() {
		Assert.assertEquals(ABBA.IMPOSSIBLE, abba.canObtain(TEST_FIVE_INITIAL, TEST_FIVE_TARGET));
	}
}
