package aoc2018.day4;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import util.Util;

public class ReposeRecord {
	static List<String> lines = Util.getLines("day/4/input").stream()
			.sorted()
			.collect(Collectors.toList());
	
	static Map<Integer, int[]> minuteMap = new HashMap<Integer, int[]>();

	public static void main(String[] args) throws IOException {
		int currentID = -1;
		for(int i = 0; i < lines.size(); i++) {
			String[] split = lines.get(i).split("[^a-zA-Z0-9]+");

			if(split.length > 8) {
				currentID = Integer.parseInt(split[7]);

				if(minuteMap.get(currentID) == null)
					minuteMap.put(currentID, new int[61]);

				if(Integer.parseInt(split[4]) == 23)
					split[5] = "00";
			}

			if(split[6].equals("falls")) {
				int startMinute = Integer.parseInt(split[5]);
				int endMinute = Integer
						.parseInt(lines.get(i + 1).split("[^a-zA-Z0-9']+")[5]);

				for(int j = startMinute; j < endMinute; j++) {
					minuteMap.get(currentID)[j]++;
					minuteMap.get(currentID)[60]++;
				}

				i++;
			}
		}

		Entry<Integer, int[]> sleepyGuard = minuteMap.entrySet().stream()
				.max((g1, g2) -> g1.getValue()[60] - g2.getValue()[60])
				.get();
		int sleepiestMinute = Stream.iterate(0, i -> ++i)
				.limit(60)
				.max((m1, m2) -> sleepyGuard.getValue()[m1]
						- sleepyGuard.getValue()[m2])
				.get();
		System.out.println(sleepyGuard.getKey() * sleepiestMinute);

		Entry<Integer, int[]> minuteGuard = minuteMap.entrySet().stream()
				.max((g1, g2) -> Arrays.stream(g1.getValue())
						.limit(60)
						.max()
						.getAsInt() -
						Arrays.stream(g2.getValue())
								.limit(60)
								.max()
								.getAsInt())
				.get();
		int sleepiestMinute2 = Stream.iterate(0, i -> ++i)
				.limit(60)
				.max((m1, m2) -> minuteGuard.getValue()[m1]
						- minuteGuard.getValue()[m2])
				.get();
		System.out.println(minuteGuard.getKey() * sleepiestMinute2);
	}
}
