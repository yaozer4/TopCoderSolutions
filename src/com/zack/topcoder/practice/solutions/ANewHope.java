package com.zack.topcoder.practice.solutions;

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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class Description
 * Created on   3/11/16
 *
 * @author Zack Yao
 */
public class ANewHope {
	public static final int INVALID_INPUT = -1;
	public int count(int[] firstWeek, int[] lastWeek, int D) {
		// Find our week length
		int daysInWeek = firstWeek.length;
		Map<Integer, Integer> desiredPositions = new HashMap<>();
		if (daysInWeek != lastWeek.length) {
			return INVALID_INPUT;
		}
		for (int i = 0; i < daysInWeek; i++) {
			desiredPositions.put(lastWeek[i], i);
		}
		// Initialize count to be 1 since it will have to be at least one week
		int count = 1;
		while (true) {
			// If we found a match, then break out of the loop and return the count
			if (Arrays.equals(firstWeek, lastWeek)) {
				break;
			}
			// Create a new array with the same size as a temporary
			int[] nextWeek = new int[daysInWeek];
			// Fill with negative ones to differentiate
			Arrays.fill(nextWeek, -1);

			// For each day in the week work backwards
			for (int i = daysInWeek - 1; i >= 0; i--) {
				// Get the shirt value of index i
				int shirtBeingWorn = firstWeek[i];
				// Determine if the next available usage of the shirt will be in the next week
				int nextAvailableArrayPosition = (D + i) - daysInWeek;

				// If the value of nextAvailableArrayPosition is negative we can assume that it's save to put anywhere
				if (nextAvailableArrayPosition <= desiredPositions.get(shirtBeingWorn)) {
					// So we'll put it where it wants to go
					nextAvailableArrayPosition = desiredPositions.get(shirtBeingWorn);
				}
				// Loop to find the next available spot in the array
				while (true) {
					// In case we've decremented too far, we'll wrap it around the week
					if (nextAvailableArrayPosition < 0) {
						nextAvailableArrayPosition += daysInWeek;
					}

					// If we've found a -1 that is a free spot in the array
					if (nextWeek[nextAvailableArrayPosition] == -1) {
						// Put the shirt in either it's next available spot (if we couldn't put it where it wanted to
						// go yet) or where it desires to go.
						nextWeek[nextAvailableArrayPosition] = shirtBeingWorn;
						break;
					} else {
						// Decrement index in case we can't put it in that spot
						nextAvailableArrayPosition--;
					}
				}
			}
			// Update the firstWeek to our newly created week
			firstWeek = nextWeek;
			// Increment the count
			count++;
		}
		return count;
	}
}

