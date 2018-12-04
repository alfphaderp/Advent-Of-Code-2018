package aoc2018.day3;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

import util.Util;

public class NoMatterHowYouSliceIt {
	static List<String> lines = Util.getLines("2018/day/3/input");

	static int[][] fabric = new int[1000][1000];
	static BitSet collisions = new BitSet();

	public static void main(String[] args) {
		for(String line : lines) {
			String[] nums = line.split("[^0-9]+");
			for(int i = Integer.parseInt(nums[3]); i < Integer.parseInt(nums[3])
					+ Integer.parseInt(nums[5]); i++)
				for(int j = Integer.parseInt(nums[2]); j < Integer
						.parseInt(nums[2]) + Integer.parseInt(nums[4]); j++)
					if(fabric[i][j] == 0)
						fabric[i][j] = Integer.parseInt(nums[1]);
					else {
						if(fabric[i][j] != -1) {
							collisions.set(fabric[i][j]);
							collisions.set(Integer.parseInt(nums[1]));
						}
						fabric[i][j] = -1;
					}
		}

		long sharedFabric = Arrays.stream(fabric)
				.flatMapToInt(a -> Arrays.stream(a))
				.filter(i -> i == -1)
				.count();
		System.out.println(sharedFabric);

		System.out.println(collisions.nextClearBit(1));
	}
}
