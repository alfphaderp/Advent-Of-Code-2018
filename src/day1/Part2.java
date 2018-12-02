package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Part2 {	
	public static void main(String[] args) throws IOException {
		List<Integer> frequencyChanges = Files.lines(Paths.get("day/1/input"))
											  .parallel()
											  .map(Integer::parseInt)
											  .collect(Collectors.toList());
		
		Set<Integer> pastFrequencies = new HashSet<Integer>();
		
		int frequency = 0;
		
		for(int i = 0; !pastFrequencies.contains(frequency); i++) {
			if(i == frequencyChanges.size())
				i = 0;
			pastFrequencies.add(frequency);
			frequency += frequencyChanges.get(i);
		}
		
		System.out.println(frequency);
	}
}
