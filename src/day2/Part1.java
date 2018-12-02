package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {
	public static void main(String[] args) throws IOException {
		List<String> labels = Files.lines(Paths.get("day/2/input"))
								   .parallel()
								   .collect(Collectors.toList());
		
		int twosCount = 0, threesCount = 0;
		
		for(String label : labels) {
			int[] counts = new int[26];
			
			for(int i = 0; i < label.length(); i++) {
				int index = label.charAt(i) - 'a';
				counts[index]++;
			}
			
			if(Arrays.stream(counts).anyMatch(i -> i == 2))
				twosCount++;
			if(Arrays.stream(counts).anyMatch(i -> i == 3))
				threesCount++;
		}
		
		System.out.println(twosCount * threesCount);
	}
}
