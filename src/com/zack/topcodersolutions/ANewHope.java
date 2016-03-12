package com.zack.topcodersolutions;

/* Problem Statement
	In a galaxy far far away... each week has N days.
	Luke Skywalker has exactly N shirts.
	The shirts are numbered 1 through N.
	Each day he wears one of those N shirts.
	Each week he wears each shirt exactly once.

	In different weeks Luke may wear his shirts in different orders.
	However, not all orders are always possible.
	Whenever Luke wears a shirt for a day, he has to wash it before he can use it again.
	Washing and drying a shirt takes D-1 full days.
	In other words, if he wears a shirt on day x, the earliest day when he can wear it again is day x+D.

	Master Yoda recently sent Luke on a training mission that lasted for some unknown number of full N-day weeks.
	He remembers the order in which he wore his shirts during the first week of the mission. He also remembers the
	order in which he wore his shirts during the last week of the mission. You are given this information in s
	firstWeek and lastWeek. Each of these s contains N elements: the numbers of shirts he wore during that week,
	in order. You are also given the number of days D that it takes to wash a shirt.

	For example, assume that N = 4, firstWeek = {1,2,3,4}, and lastWeek = {4,3,2,1} and D = 3.
	It is possible that this particular mission took four weeks. One possible order in which Luke
	could have worn his shirts looks as follows:
		week 1: {1,2,3,4}
		week 2: {2,3,4,1}
		week 3: {3,4,2,1}
		week 4: {4,3,2,1}
	Given firstWeek, lastWeek and D, compute and return the smallest number of weeks the mission could have taken.
*/

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
